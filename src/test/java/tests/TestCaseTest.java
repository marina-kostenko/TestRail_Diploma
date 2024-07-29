package tests;

import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.TestDataGeneration;

import java.io.File;

public class TestCaseTest extends BaseTest {

    @BeforeMethod(onlyForGroups = "TestCaseShouldBeCreated", alwaysRun = true)
    public void beforeCreateTestCase()
    {
        testCase = TestDataGeneration.generateTestCase();

        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(testCase);
        addTestCasePage.clickCreateTestCaseButton();
        testCaseInfoPage.returnToDashboardTab();
        dashboardPage.isPageOpened();

    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new test case")
    public void createTestCase() {

        testCase = TestDataGeneration.generateTestCase();

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(testCase);
        addTestCasePage.clickCreateTestCaseButton();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully added the new test case. Add another");
        TestCase actualTestCase = testCaseInfoPage.getTestCaseInfo();
        Assert.assertEquals(actualTestCase, testCase);


    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new test case(Steps)")
    public void createTestCaseSteps() {

        testCase = TestDataGeneration.generateTestCaseSteps();

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCaseSteps(testCase);
        addTestCasePage.clickCreateTestCaseButton();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully added the new test case. Add another");
        TestCase actualTestCase = testCaseInfoPage.getTestCaseStepsInfo();
        Assert.assertEquals(actualTestCase, testCase);


    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new test case with attachment")
    public void createTestCaseWithAttachment() {
        testCase = TestDataGeneration.generateTestCase();
        File uploadFile = new File(PropertyReader.getProperty("filepath"));

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

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully added the new test case. Add another");
        Assert.assertTrue(testCasesPage.isAttachmentDisplayed());
    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Complete test for TestCase")
    public void testCaseCompleteTest() {

        testCase = TestDataGeneration.generateTestCase();
        TestCase editedTestCase = TestDataGeneration.generateEditTestCaseSteps();
        File uploadFile = new File(PropertyReader.getProperty("filepath"));

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(testCase);
        addTestCasePage.clickCreateTestCaseButton();
        testCaseInfoPage.clickEditTestCaseButton();
        addTestCasePage.addAttachment(uploadFile);
        addTestCasePage.editTestCaseToTestCaseSteps(editedTestCase);
        addTestCasePage.clickCreateTestCaseButton();
        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully updated the test case.");
        Assert.assertTrue(testCasesPage.isAttachmentDisplayed());
        TestCase actualTestCase = testCaseInfoPage.getTestCaseStepsInfo();
        Assert.assertEquals(actualTestCase, editedTestCase);
        testCaseInfoPage.clickTestCasesTab();
        testCasesPage.clickDeleteTestCaseButton(editedTestCase.getTitle());

        confirmationModalForTestCase.waitConfirmationDialogToTestCaseIsDisplayed();
        confirmationModalForTestCase.clickDeletePermanentlyButton();
        confirmationModalForTestCase.waitSecondConfirmationDialogToTestCaseIsDisplayed();
        confirmationModalForTestCase.clickSecondDeletePermanentlyButton();

        testCasesPage.waiting();
        Assert.assertFalse(testCasesPage.isTestCaseCreated(editedTestCase.getTitle()));

    }
  
    @Test(groups = {"regression", "userShouldBeLogin", "ProjectShouldBeCreated", "TestCaseShouldBeCreated"}, description = "Edit testcase")
    public void editTestCase(){
        TestCase updateTestCase = TestDataGeneration.generateUpdateTestCase();

        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickTestCaseLinkByName(testCase.getTitle());
        testCaseInfoPage.isPageOpened();
        testCaseInfoPage.clickEditTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.editTestCase(updateTestCase);
        addTestCasePage.clickCreateTestCaseButton();
        testCaseInfoPage.isPageOpened();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully updated the test case.");
        TestCase actualTestCase = testCaseInfoPage.getTestCaseInfo();
        Assert.assertEquals(actualTestCase, updateTestCase);

    }

    @Test(groups = {"regression", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new test case with invalid Estimate")
    public void createTestCaseNegativeTest()
    {
        TestCase invalidTestCase = TestDataGeneration.generateInvalidEstimateTestCase();
        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(invalidTestCase);
        addTestCasePage.clickCreateTestCaseButton();

        Assert.assertEquals(addTestCasePage.getErrorMessage(), "Field Estimate is not in a valid time span format.");
    }

}
