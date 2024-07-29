package pages;

import decorators.Button;
import enums.TestCasePriority;
import enums.TestCaseStatus;
import enums.TestCaseType;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCaseInfoPage extends BaseDashboardPage {
    private static final By TITLE = By.cssSelector("[data-testid ='testCaseContentHeaderTitle']");
    private static final By TYPE = By.cssSelector("td[data-testid ='testCaseViewCellTypeId']");
    private static final By PRIORITY = By.cssSelector("td[data-testid='testCaseViewCellPriorityId']");
    private static final By STATUS = By.id("cell_status");
    private static final By PRECONDITIONS = By.xpath("//*[text()='Preconditions']//following::p");
    private static final By STEPS = By.xpath("//*[text()='Steps']//following::p");
    private static final By EXPECTED_RESULT = By.xpath("//span[text() = 'Expected Result']/../following-sibling::div[@class='field-content']//p");
    private static final By STEPS_EXPECTED_RESULT = By.cssSelector(".step-content + .hidden-vertical  div p");
    private static final By STEPS_DESCRIPTION = By.xpath("//div[@class= 'hidden-vertical']/div/p");
    private static final By EDIT_BUTTON_TEST_CASE = By.cssSelector("[data-testid ='testCaseEditButton']");


    public TestCaseInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(STATUS));
    }

    public TestCase getTestCaseInfo() {
        TestCase resultTestCase = TestCase.builder()
                .setTitle(driver.findElement(TITLE).getText())
                .setType(TestCaseType.getFromName(driver.findElement(TYPE).getText().replace("Type\n", "")))
                .setPriority(TestCasePriority.getFromName(driver.findElement(PRIORITY).getText().replace("Priority\n", "")))
                .setStatus(TestCaseStatus.getFromName(driver.findElement(STATUS).getText().replace("Status\n", "")))
                .setPreconditions(driver.findElement(PRECONDITIONS).getText())
                .setSteps(driver.findElement(STEPS).getText())
                .setExpectedResult(driver.findElement(EXPECTED_RESULT).getText())
                .build();
        return resultTestCase;
    }

    public TestCase getTestCaseStepsInfo() {
        TestCase resultTestCase = TestCase.builder()
                .setTitle(driver.findElement(TITLE).getText())
                .setType(TestCaseType.getFromName(driver.findElement(TYPE).getText().replace("Type\n", "")))
                .setPriority(TestCasePriority.getFromName(driver.findElement(PRIORITY).getText().replace("Priority\n", "")))
                .setStatus(TestCaseStatus.getFromName(driver.findElement(STATUS).getText().replace("Status\n", "")))
                .setPreconditions(driver.findElement(PRECONDITIONS).getText())
                .setStepDescription(driver.findElement(STEPS_DESCRIPTION).getText())
                .setStepsExpectedResult(driver.findElement(STEPS_EXPECTED_RESULT).getText())
                .build();
        return resultTestCase;
    }

    @Step("Click 'Edit Test case' button")
    public void clickEditTestCaseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(EDIT_BUTTON_TEST_CASE));
        new Button(driver, EDIT_BUTTON_TEST_CASE).click();
    }
}
