package apiTests;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;
import java.io.FileReader;
import java.io.IOException;


public class TestCaseApiTest extends BaseApiTest {
    @Test(groups = {"api", "need create project"}, description = "Creating new test case by Api from Json file with section")
    public void createTestCase() throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/ApiTestData/createTestCaseRequestBody.json";
        TestCase testCase = new Gson().fromJson(new FileReader(filePath), TestCase.class);

        section = TestDataGeneration.generateSection();
        section.setSuiteId(null);
        Response response = sectionController.addSection(section, projectId);
        int sectionId = response.getBody().jsonPath().get("id");

        response = testCaseController.createTestCase(sectionId, testCase);

        Assert.assertEquals(200, response.getStatusCode());

        TestCase actualTestCase = response.getBody().as(TestCase.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualTestCase, testCase);
    }
}
