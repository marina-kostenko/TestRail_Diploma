package controllers;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.TestRun;

import static io.restassured.RestAssured.given;

public class TestRunController extends BaseController {

    public Response createTestRun(TestRun testRun, int projectId)
    {
        return given()
                .body(testRun, ObjectMapperType.GSON)
                .pathParam("project_id", projectId)
                .when()
                .post("index.php?/api/v2/add_run/{project_id}")
                .then()
                .log().all()
                .extract().response();
    }

    public Response getTestRun(int testRunId)
    {
        return given()
                .pathParam("run_id", testRunId)
                .when()
                .get("index.php?/api/v2/get_run/{run_id}")
                .then()
                .log().all()
                .extract().response();
    }

    public Response updateTestRun(TestRun testRun, int testRunId)
    {
        return given()
                .body(testRun, ObjectMapperType.GSON)
                .pathParam("run_id", testRunId)
                .when()
                .post("index.php?/api/v2/update_run/{run_id}")
                .then()
                .log().all()
                .extract().response();
    }

    public Response deleteTestRun(int testRunId)
    {
        return given()
                .pathParam("run_id", testRunId)
                .when()
                .post("index.php?/api/v2/delete_run/{run_id}")
                .then()
                .log().all()
                .extract().response();
    }
}
