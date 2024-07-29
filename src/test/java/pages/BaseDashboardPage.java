package pages;

import decorators.Button;
import decorators.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

@Log4j2
public class BaseDashboardPage extends BasePage {
    private static final By DASHBOARD_TAB = By.id("navigation-dashboard");
    private static final By RETURN_TO_DASHBOARD = By.id("navigation-dashboard-top");
    private static final By MILESTONES_TAB = By.id("navigation-milestones");
    private static final By TEST_CASES_TAB = By.id("navigation-suites");
    private static final By ADD_ATTACHMENT_BUTTON = By.id("entityAttachmentListEmptyIcon");
    private static final By ADD_ATTACHMENT_DIALOG_SUBMIT_BUTTON = By.cssSelector("[data-testid='addAttachmentDialogSubmit']");
    private static final By ATTACHMENT_LIST = By.cssSelector("[data-testid='attachmentListItem']");
    private static final By FILE_INPUT = By.xpath("//input[@class='dz-hidden-input'][last()]");
    private static final By DELETE_BUTTON = By.cssSelector("[data-testid='attachmentsTabLibraryDeleteAttachment']");
    private static final By QUESTION_BUTTON = By.id("_pendo-badge_Hhf7H23vJ3hk1jdtR271Im-1A3o");


    public BaseDashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(new Button(driver, TEST_CASES_TAB)));
    }

    @Step("Click 'Milestone' tab")
    public void clickMilestonesTab() {
        driver.findElement(MILESTONES_TAB).click();
    }

    @Step("Click 'Test Case' tab")
    public void clickTestCasesTab() {
        driver.findElement(TEST_CASES_TAB).click();
    }

    public boolean isDashboardTabDisplayed() {
        try {
            driver.findElement(DASHBOARD_TAB).isDisplayed();

        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Step("Click 'Dashboard' tab")
    public void returnToDashboardTab() {
        if (isDashboardTabDisplayed()) {
            driver.findElement(DASHBOARD_TAB).click();
        } else {
            driver.findElement(RETURN_TO_DASHBOARD).click();
        }
    }
    @Step("Add attachment")
    public void addAttachment(File uploadFile) {
        log.info("Adding attacment - {}", uploadFile);
        new Button(driver, ADD_ATTACHMENT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_ATTACHMENT_DIALOG_SUBMIT_BUTTON));
        new Input(driver, FILE_INPUT).setValue(uploadFile.getAbsolutePath());
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_BUTTON));
        new Button(driver, ADD_ATTACHMENT_DIALOG_SUBMIT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ATTACHMENT_LIST));

    }

    public void waitingUploadingQuestionIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(QUESTION_BUTTON));
    }

    public void waiting() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
