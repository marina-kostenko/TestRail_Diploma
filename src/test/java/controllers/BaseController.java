package controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseController {
    public BaseController() {
        RestAssured.baseURI = PropertyReader.getProperty("base_url");
        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"))
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}


