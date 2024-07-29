package controllers;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.TestCase;

import static io.restassured.RestAssured.given;

public class TestCaseController extends BaseController {
    public Response createTestCase(int sectionId, TestCase testCase) {

        return given()
                .pathParams("section_id", sectionId)
                .body(testCase, ObjectMapperType.GSON)
                .when()
                .post("index.php?/api/v2/add_case/{section_id}")
                .then().log().all()
                .extract().response();
    }
}
