package controllers;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Section;

import static io.restassured.RestAssured.given;

public class SectionController extends BaseController {

    public Response addSection(Section section, int projectId) {

        return given()
                .pathParams("project_id", projectId)
                .body(section, ObjectMapperType.GSON)
                .when()
                .post("index.php?/api/v2/add_section/{project_id}")
                .then().log().all()
                .extract().response();
    }

    public Response updateSection(Section section, int sectionId) {

        return given()
                .pathParams("section_id", sectionId)
                .body(section, ObjectMapperType.GSON)
                .when()
                .post("index.php?/api/v2/update_section/{section_id}")
                .then().log().all()
                .extract().response();
    }

    public Response deleteSection(int sectionId) {

        return given()
                .pathParams("section_id", sectionId)
                .when()
                .post("index.php?/api/v2/delete_section/{section_id}")
                .then().log().all()
                .extract().response();
    }

    public Response getSections(int projectId, int suiteId) {

        return given()
                .pathParams("project_id", projectId)
                .pathParams("suite_id", suiteId)
                .when()
                .get("index.php?/api/v2/get_sections/{project_id}&suite_id={suite_id}")
                .then().log().all()
                .extract().response();
    }
}
