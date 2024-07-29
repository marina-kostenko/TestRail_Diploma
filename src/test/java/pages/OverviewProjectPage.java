package pages;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewProjectPage extends BaseDashboardPage {
    private static final By PROJECT_NAME = By.cssSelector("[data-testid='testCaseContentHeaderTitle']");
    private static final By PROJECT_ANNOUNCEMENT = By.cssSelector("[data-testid='projectAnnouncement']");

    public OverviewProjectPage(WebDriver driver) {
        super(driver);
    }

    public Project getProjectInfo() {
        Project resultProject;
        if (driver.findElement(PROJECT_ANNOUNCEMENT).isDisplayed()) {
            resultProject = Project.builder()
                    .setName(driver.findElement(PROJECT_NAME).getText())
                    .setAnnouncement(driver.findElement(PROJECT_ANNOUNCEMENT).getText())
                    .build();
        } else {
            resultProject = Project.builder()
                    .setName(driver.findElement(PROJECT_NAME).getText())
                    .build();
        }
        return resultProject;
    }

}
