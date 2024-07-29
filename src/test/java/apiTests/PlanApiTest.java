package apiTests;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Plan;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PlanApiTest extends BaseApiTest {
    protected int planId;

    @BeforeMethod(onlyForGroups = "beforeCreatePlan", alwaysRun = true)
    public void beforeCreatePlan() {
        plan = Plan.builder().name("Test Plan").description("Description for plan").milestoneId(milestoneId).build();
        Response response = planController.addPlan(projectId, plan);
        planId = response.getBody().jsonPath().getInt("id");
    }

    @Test(groups = {"api", "need create project", "need create milestone"}, description = "Creating new plan by Api and than closing it")
    public void addAndClosePlan() {
        plan = Plan.builder().name("Test Plan").description("Description for plan").milestoneId(milestoneId).build();
        Response response = planController.addPlan(projectId, plan);

        Assert.assertEquals(response.getStatusCode(), 200);
        Plan actualPlan = response.getBody().as(Plan.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualPlan, plan);
        int planId = response.getBody().jsonPath().getInt("id");

        response = planController.closePlan(planId);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(groups = {"api", "need create project", "need create milestone", "beforeCreatePlan"}, description = "Creating new plan by Api and than deleting it")
    public void deletePlan() {
        Response response = planController.deletePlan(planId);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(groups = {"api", "need create project", "need create milestone", "beforeCreatePlan"}, description = "Updating plan by Api")
    public void updatePlan() throws FileNotFoundException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/ApiTestData/createPlanRequestBody.json";
        Plan newPlan = new Gson().fromJson(new FileReader(filePath), Plan.class);
        newPlan.setMilestoneId(milestoneId);
        Response response = planController.updatePlan(newPlan, planId);

        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
