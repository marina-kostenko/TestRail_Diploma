package pages;

import decorators.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AddProjectPage extends BasePage {
    private static final String PROJECT_NAME = "addProjectNameInput";
    private static final String ANNOUNCEMENT = "addEditProjectAnnouncement";
    private static final String CHECK_BOX_SHOW_THE_ANNOUNCEMENT = "addEditProjectShowAnnouncement";
    private static final String CHECK_BOX_ENABLE_TEST_CASE_APPROVALS = "addEditProjectCaseStatusesEnabled";
    private static final String ADD_PROJECT_BUTTON = "addEditProjectAddButton";
    private static final By PROJECTS_LINK = By.cssSelector("[data-testid = 'administrationSidebarProjects']");
    private static final By ERROR_MESSAGE = By.cssSelector("link + div");
    private static final String REFERENCES_TAB = "//a[@id='projects-tabs-references']";
    private static final By REFERENCES_INPUT = By.id("reference_id_url");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(new Button(driver, ADD_PROJECT_BUTTON)));
    }

    @Step("Creating new project")
    public void createNewProject(Project project) {
        log.info("Creating Project - {}", project.getName());
        if (project.getName() != null) {
            new Input(driver, PROJECT_NAME).setValue(project.getName());
        }

        if (project.getAnnouncement() != null) {
            new TextArea(driver, ANNOUNCEMENT).setValue(project.getAnnouncement());
        }

        if (project.isShowAnnouncement()) {
            new CheckBox(driver, CHECK_BOX_SHOW_THE_ANNOUNCEMENT).check();
        }
        new RadioButton(driver, project.getProjectType().getId()).select();

        if (project.isEnableTestCaseApprovals()) {
            new CheckBox(driver, CHECK_BOX_ENABLE_TEST_CASE_APPROVALS).check();
        }
        new Button(driver, ADD_PROJECT_BUTTON).click();
    }
    @Step("Creating new project")
    public void createProjectWithReferences(Project project) {
        log.info("Creating Project with references - {}", project.getName());
        if (project.getName() != null) {
            new Input(driver, PROJECT_NAME).setValue(project.getName());
        }
        clickReferencesTab();
        if (project.getReferences() != null) {
            new Input(driver,REFERENCES_INPUT).setValue(project.getReferences());
        }

        new Button(driver, ADD_PROJECT_BUTTON).click();
    }

    @Step("Editing project")
    public void editProject(Project project) {
        new Input(driver, PROJECT_NAME).clearAndSetValue(project.getName());

        if (project.getAnnouncement() != null) {
            new TextArea(driver, ANNOUNCEMENT).clearAndSetValue(project.getAnnouncement());

        } else {
            new TextArea(driver, ANNOUNCEMENT).setValue(project.getAnnouncement());
        }
        if (project.isShowAnnouncement()) {
            new CheckBox(driver, CHECK_BOX_SHOW_THE_ANNOUNCEMENT).check();
        }
        new Button(driver, ADD_PROJECT_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Click Projects link in Administration")
    public void clickProjectsLink() {
        driver.findElement(PROJECTS_LINK).click();
    }
    @Step("Click References Tab ")
    public void clickReferencesTab()
    {
        driver.findElement(By.xpath(REFERENCES_TAB)).click();
    }

}