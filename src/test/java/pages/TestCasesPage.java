package pages;

import decorators.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

import java.util.List;

public class TestCasesPage extends BaseDashboardPage {
    private static final String ADD_TEST_CASE_BUTTON = "sidebarCasesAdd";
    private static final String ADD_SECTION_BUTTON = "addSectionInline";
    private static final String ATTACHMENT = "//div[contains(@title, '%s')]";
    private static final By TEST_CASES_LIST = By.xpath("//span[@data-testid = 'sectionCaseTitle']");
    private static final By SECTION_LIST = By.cssSelector(".groupTreeContainer a span");
    private static final String EDIT_BUTTON = "//span[text() = '%s']/..//div[contains(@class, 'icon-small-edit')]/..";
    private static final String DELETE_BUTTON = "//span[text() = '%s']/..//div[contains(@class, 'icon-small-delete')]/..";
    private static final String SECTION = "//div[@class= 'grid-title']//span[text() = '%s']";
    private static final By NO_TEST_CASE_TEXT = By.id("groupsEmpty");
    private static final String TEST_CASE_SECTION = "//span[text()='%s']/ancestor::tr";
    private static final String DELETE_TEST_CASE_BUTTON = "//span[text() = '%s']/../following::a[@class= 'deleteLink']";
    private static final String TEST_CASE_TITLE = "//tbody/tr/following-sibling::tr[starts-with(@id, 'row')]//span[text()='%s']";

    public TestCasesPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Click 'Add Test Case' button")
    public void clickAddTestCaseButton()
    {
        new Button(driver, ADD_TEST_CASE_BUTTON).click();
    }

    @Step("Click 'Add Section' button")
    public void clickAddSectionButton()
    {
        new Button(driver, ADD_SECTION_BUTTON).click();
    }


    @Step("Check {sectionName} in the list")
    public boolean isSectionCreated(String sectionName) {
        List<WebElement> sectionLists = driver.findElements(SECTION_LIST);
        return sectionLists.stream().anyMatch(section -> section.getText().equals(sectionName));
    }

    public boolean isAttachmentDisplayed() {
        return driver.findElement(By.xpath(String.format(ATTACHMENT, PropertyReader.getProperty("filename")))).isDisplayed();
    }

    @Step("Click 'Edit section' button")
    public void clickEditSectionButton(String sectionName) {
        waitingUploadingQuestionIcon();
        driver.findElement(By.xpath(String.format(EDIT_BUTTON, sectionName))).click();
    }

    @Step("Deleting Section")
    public void clickDeleteSectionButton(String sectionName) {
        waiting();
        WebElement section = driver.findElement(By.xpath(String.format(SECTION, sectionName)));
        WebElement deleteButton = driver.findElement(By.xpath(String.format(DELETE_BUTTON, sectionName)));
        Actions actions = new Actions(driver);
        actions.moveToElement(section).moveToElement(deleteButton).click().build().perform();
    }

    @Step("Deleting Test Case")
    public void clickDeleteTestCaseButton(String testCaseName) {
        waiting();
        WebElement testCase = driver.findElement(By.xpath(String.format(TEST_CASE_SECTION, testCaseName)));
        WebElement deleteButton = driver.findElement(By.xpath(String.format(DELETE_TEST_CASE_BUTTON, testCaseName)));
        Actions actions = new Actions(driver);
        actions.moveToElement(testCase).moveToElement(deleteButton).click().build().perform();
    }

    public void waitEmptyPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NO_TEST_CASE_TEXT));
    }

    @Step("Check test case in the list on TestCases page")
    public boolean isTestCaseCreated(String testCaseName) {
        List<WebElement> testCases = driver.findElements(TEST_CASES_LIST);
        return testCases.stream().anyMatch(testCase -> testCase.getText().equals(testCaseName));

    }

    @Step("Click TestCase Link by name = '{testCaseName}'")
    public void clickTestCaseLinkByName(String testCaseTitle)
    {
        driver.findElement(By.xpath(String.format(TEST_CASE_TITLE, testCaseTitle))).click();
    }
}