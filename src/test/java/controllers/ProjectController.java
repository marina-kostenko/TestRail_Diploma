package controllers;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;

import static io.restassured.RestAssured.given;

public class ProjectController extends BaseController {

    public Response createProject(Project project) {

        return given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post("index.php?/api/v2/add_project")
                .then().log().all()
                .extract().response();
    }

    public Response deleteProject(int projectId) {

        return given()
                .pathParams("project_id", projectId)
                .when()
                .post("index.php?/api/v2/delete_project/{project_id}")
                .then().log().all()
                .extract().response();
    }

    public Response getProject(int projectId) {

        return given()
                .pathParams("project_id", projectId)
                .when()
                .get("index.php?/api/v2/get_project/{project_id}")
                .then().log().all()
                .extract().response();
    }

    public Response getProjects() {

        return given()
                .when()
                .get("index.php?/api/v2/get_projects")
                .then().log().all()
                .extract().response();
    }


}



