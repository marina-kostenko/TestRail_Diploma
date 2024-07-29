package tests;

import models.Section;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.TestDataGeneration;

import java.io.File;

public class SectionTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new Section")
    public void createSection() {

        section = TestDataGeneration.generateSection();
        File uploadFile = new File(PropertyReader.getProperty("filepath"));

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddSectionButton();
        addSectionPage.createSection(section);
        addSectionPage.addAttachment(uploadFile);
        addSectionPage.clickAddSection();

        Assert.assertTrue(testCasesPage.isSectionCreated(section.getName()));

    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Complete test for Section")
    public void sectionCompleteTest() {

        Section section = TestDataGeneration.generateSection();
        Section editedSection = TestDataGeneration.generateEditSection();
        File uploadFile = new File(PropertyReader.getProperty("filepath"));

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddSectionButton();
        addSectionPage.createSection(section);
        addSectionPage.clickAddSection();
        testCasesPage.clickEditSectionButton(section.getName());
        addSectionPage.addAttachment(uploadFile);
        addSectionPage.editSection(editedSection);
        addSectionPage.clickAddSection();
        testCasesPage.clickDeleteSectionButton(editedSection.getName());
        confirmationModal.waitConfirmationDialogToDisplayed();
        confirmationModal.checkCheckbox();
        confirmationModal.clickDeleteButton();

        testCasesPage.waitEmptyPage();
        Assert.assertFalse(testCasesPage.isSectionCreated(editedSection.getName()));

    }

}
