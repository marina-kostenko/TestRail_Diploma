
package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProjectsPage extends BaseDashboardPage {
    private static final By PROJECTS_LIST = By.cssSelector(".hoverSensitive td a");
    private static final String EDIT_PROJECT_CONTAINER = "//a[text()='%s']/following::div[@data-testid='projectEditButton']";
    private static final String PROJECT_CONTAINER = "//td/a[text() = '%s']";
    private static final String OPEN_OVERVIEW_PROJECT_BUTTON_CONTAINER = ("//a[text() = '%s']/following-sibling:: span/a");
    private static final String DELETE_PROJECT_CONTAINER = "//a[text()='%s']/ancestor::tr//div[@data-testid='projectDeleteButton']";


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Check {projectName} project in the list on Projects page")
    public boolean isProjectCreated(String projectName) {
        List<WebElement> projectLists = driver.findElements(PROJECTS_LIST);
        return projectLists.stream().anyMatch(project -> project.getText().equals(projectName));
    }

    @Step("Click 'Delete project' button")
  
    public void clickDeleteProjectButton(String projectName) {
        waitingUploadingQuestionIcon();

        driver.findElement(By.xpath(String.format(DELETE_PROJECT_CONTAINER, projectName))).click();
    }

    @Step("Click 'Edit project' button")
    public void clickEditProjectButton(String projectName) {
        waitingUploadingQuestionIcon();
        driver.findElement(By.xpath(String.format(EDIT_PROJECT_CONTAINER, projectName))).click();
    }

    @Step("Open Project info page")
    public void clickOpenOverviewProjectPageButton(String projectName) {
        WebElement project = driver.findElement(By.xpath(String.format(PROJECT_CONTAINER, projectName)));
        WebElement openOverview = driver.findElement(By.xpath(String.format(OPEN_OVERVIEW_PROJECT_BUTTON_CONTAINER, projectName)));
        Actions actions = new Actions(driver);
        actions.moveToElement(project).moveToElement(openOverview).click().build().perform();
    }

}
