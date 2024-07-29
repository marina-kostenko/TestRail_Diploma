package apiTests;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class ProjectApiTest extends BaseApiTest {
    @Test(groups = "api", description = "Creating new project by Api")
    public void createProject() {
        project = TestDataGeneration.generateProject();
        Response response = projectController.createProject(project);

        Assert.assertEquals(response.getStatusCode(), 200);
        Project actualProject = response.getBody().as(Project.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualProject, project);
    }

    @Test(groups = {"api", "need create project"}, description = "Deleting project by Api")
    public void deleteProject() {
        Response response = projectController.deleteProject(projectId);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(groups = {"api", "need create project"}, description = "Checking project information")
    public void getProject() {
        Response response = projectController.getProject(projectId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Project actualProject = response.getBody().as(Project.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualProject, project);
    }

    @Test(groups = {"api", "need create project"}, description = "Checking all projects")
    public void getProjects() {
        Response response = projectController.getProjects();
        int count = response.getBody().jsonPath().getList("projects").size();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(count != 0);
    }

}

