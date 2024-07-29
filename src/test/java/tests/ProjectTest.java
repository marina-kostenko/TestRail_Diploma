
package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class ProjectTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new project with all fields")
    public void createNewProject()
    {
        this.project = TestDataGeneration.generateProject();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully added the new project.");
        Assert.assertTrue(projectsPage.isProjectCreated(project.getName()));
        projectsPage.clickOpenOverviewProjectPageButton(project.getName());
        Project actualProject = overviewProjectPage.getProjectInfo();
        Assert.assertEquals(actualProject, project);
    }

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new project without name")
    public void createNewProjectWithoutName()
    {
        this.project = TestDataGeneration.generateProjectWithoutName();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        Assert.assertEquals(addProjectPage.getErrorMessage(), "Field Name is a required field.");
    }

    @Test(groups = {"regression", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Edit project")
    public void editProject()
    {
        Project updatedProject = TestDataGeneration.generateUpdateProject();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.clickProjectsLink();
        projectsPage.clickEditProjectButton(project.getName());
        addProjectPage.editProject(updatedProject);
        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully updated the project.");
        Assert.assertTrue(projectsPage.isProjectCreated(updatedProject.getName()));
    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Delete project {projectName}")
    public void deleteProject()
    {
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.clickProjectsLink();
        projectsPage.clickDeleteProjectButton(project.getName());
        confirmationModal.waitConfirmationDialogToDisplayed();
        confirmationModal.checkCheckbox();
        confirmationModal.clickDeleteButton();
        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully deleted the project.");
        Assert.assertFalse(projectsPage.isProjectCreated(project.getName()));
    }

    @Test(groups = {"smoke", "userShouldBeLogin",}, description = "Full Workflow Project Test")
    public void projectCompleteTest()
    {
        Project updatedProject = TestDataGeneration.generateUpdateProject();
        project = TestDataGeneration.generateProject();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        projectsPage.returnToDashboardTab();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.clickProjectsLink();
        projectsPage.clickEditProjectButton(project.getName());
        addProjectPage.editProject(updatedProject);
        projectsPage.returnToDashboardTab();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.clickProjectsLink();
        projectsPage.clickDeleteProjectButton(updatedProject.getName());
        confirmationModal.waitConfirmationDialogToDisplayed();
        confirmationModal.checkCheckbox();
        confirmationModal.clickDeleteButton();
        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully deleted the project.");
        Assert.assertFalse(projectsPage.isProjectCreated(project.getName()));
    }

    @Test(groups = {"regression", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new project with invalid references")
    public void createProjectNegativeTest()
    {
        this.project = TestDataGeneration.generateInvalidReferenciesProject();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createProjectWithReferences(project);
        Assert.assertEquals(addProjectPage.getErrorMessage(), "Field Reference View Url is not a valid URL.");

    }
}