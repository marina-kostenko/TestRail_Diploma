package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.TestDataGeneration;

import java.io.File;

public class ProjectAndTestCaseCreationTest extends BaseTest {

    @Test(groups = {"regression","userShouldBeLogin"}, description = "Creating project with test-cases")
    public void createProjectAndTestCaseWithAttachmentTest()
    {
        project = TestDataGeneration.generateProject();
        testCase = TestDataGeneration.generateTestCase();
        File uploadFile = new File(PropertyReader.getProperty("filepath"));

        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        projectsPage.returnToDashboardTab();
        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(testCase);
        addTestCasePage.addAttachment(uploadFile);
        addTestCasePage.clickCreateTestCaseButton();
        testCaseInfoPage.isPageOpened();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully added the new test case. Add another");
        Assert.assertTrue(testCasesPage.isAttachmentDisplayed());

    }
}