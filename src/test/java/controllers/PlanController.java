package controllers;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Plan;

import static io.restassured.RestAssured.given;

public class PlanController extends BaseController {

    public Response addPlan(int projectId, Plan plan) {

        return given()
                .pathParams("project_id", projectId)
                .body(plan, ObjectMapperType.GSON)
                .when()
                .post("index.php?/api/v2/add_plan/{project_id}")
                .then().log().all()
                .extract().response();
    }

    public Response closePlan(int planId) {

        return given()
                .pathParams("plan_id", planId)
                .when()
                .post("index.php?/api/v2/close_plan/{plan_id}")
                .then().log().all()
                .extract().response();
    }

    public Response deletePlan(int planId) {

        return given()
                .pathParams("plan_id", planId)
                .when()
                .post("index.php?/api/v2/delete_plan/{plan_id}")
                .then().log().all()
                .extract().response();
    }

    public Response updatePlan(Plan plan, int planId) {

        return given()
                .pathParams("plan_id", planId)
                .body(plan, ObjectMapperType.GSON)
                .when()
                .post("index.php?/api/v2/update_plan/{plan_id}")
                .then().log().all()
                .extract().response();
    }

}
