package apiTests;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import models.Section;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataGeneration;


public class SectionTest extends BaseApiTest {
    int suiteId;
    int sectionId;

    @BeforeMethod(onlyForGroups = "need create section", alwaysRun = true)
    public void beforeCreateSection() {
        project = Project.builder().setName("Project Name").setShowAnnouncement(true).setSuiteMode(3).build();
        Response response = projectController.createProject(project);
        projectId = response.getBody().jsonPath().getInt("id");

        Suite suite = Suite.builder().name("Suite_1").description("Description for Suite").build();
        response = suiteController.addSuite(suite, projectId);
        suiteId = response.getBody().jsonPath().get("id");

        section = Section.builder().setName("Section").setDescription("Description for Section").setSuiteId(suiteId).build();
        response = sectionController.addSection(section, projectId);
        sectionId = response.getBody().jsonPath().get("id");

    }

    @Test(groups = "api", description = "Creating new section by Api with Suite")
    public void createSection() {
        project = Project.builder().setName("Project Name").setShowAnnouncement(true).setSuiteMode(3).build();
        Response response = projectController.createProject(project);
        projectId = response.getBody().jsonPath().getInt("id");

        Suite suite = Suite.builder().name("Suite_1").description("Description for Suite").build();
        response = suiteController.addSuite(suite, projectId);
        int suiteId = response.getBody().jsonPath().get("id");

        section = Section.builder().setName("Section").setDescription("Description for Section").setSuiteId(suiteId).build();
        response = sectionController.addSection(section, projectId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Section actualSection = response.getBody().as(Section.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualSection, section);
    }

    @Test(groups = {"api", "need create section"}, description = "Get all sections")
    public void getSections() {
        Response response = sectionController.getSections(projectId, suiteId);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(groups = {"api", "need create section"}, description = "Updating section")
    public void updateSection() {
        section = TestDataGeneration.generateSection();
        Response response = sectionController.updateSection(section, sectionId);
        Section actualSection = response.getBody().as(Section.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(actualSection, section);
    }

    @Test(groups = {"api", "need create section"}, description = "Deleting section")
    public void deleteSection() {
        Response response = sectionController.deleteSection(sectionId);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
