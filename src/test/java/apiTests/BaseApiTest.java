package apiTests;

import controllers.*;
import io.restassured.response.Response;
import models.Milestone;
import models.Plan;
import models.Project;
import models.Section;
import models.TestRun;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.TestDataGeneration;

public abstract class BaseApiTest {
  
    protected Project project;
    protected Milestone milestone;
    protected Section section;
    protected TestRun testRun;
    protected Plan plan;
   
    protected int projectId;
    protected int milestoneId;
    protected int testRunId;
  
    ProjectController projectController = new ProjectController();
    MilestoneController milestoneController = new MilestoneController();
    SectionController sectionController = new SectionController();
    TestCaseController testCaseController = new TestCaseController();
    SuiteController suiteController = new SuiteController();
    PlanController planController = new PlanController();
    TestRunController testRunController = new TestRunController();
  

    @BeforeMethod(onlyForGroups = "need create project", alwaysRun = true)
    public void beforeCreateProject() {
        project = TestDataGeneration.generateProject();
        Response response = projectController.createProject(project);
        projectId = response.getBody().jsonPath().getInt("id");
    }

    @AfterMethod(alwaysRun = true)
    public void afterDeleteProject() {
        projectController.deleteProject(projectId);
    }

    @BeforeMethod(alwaysRun = true, onlyForGroups = "need create milestone", dependsOnMethods = "beforeCreateProject")
    public void beforeCreateMilestone() {
        milestone = TestDataGeneration.generateSimpleMilestone();
        Response response = milestoneController.createMilestone(milestone, projectId);
        milestoneId = response.getBody().jsonPath().getInt("id");
    }
  
    @BeforeMethod(alwaysRun = true, onlyForGroups = "need create testRun", dependsOnMethods = "beforeCreateMilestone")
    public void beforeCreateTestRun() {
        testRun = TestDataGeneration.generateTestRun(milestoneId);
        Response response = testRunController.createTestRun(testRun, projectId);
        testRunId = response.getBody().jsonPath().getInt("id");
    }
}
