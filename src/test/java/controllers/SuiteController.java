package controllers;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Suite;

import static io.restassured.RestAssured.given;

public class SuiteController {
    public Response addSuite(Suite suite, int projectId) {

        return given()
                .pathParams("project_id", projectId)
                .body(suite, ObjectMapperType.GSON)
                .when()
                .post("index.php?/api/v2/add_suite/{project_id}")
                .then().log().all()
                .extract().response();
    }
}
