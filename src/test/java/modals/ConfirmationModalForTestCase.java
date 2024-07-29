package modals;

import decorators.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationModalForTestCase extends BaseModal {
    private static final By DELETE_PERMANENTLY_BUTTON = By.xpath("//div[@data-testid = 'casesDeletionDialog']//a[@data-testid = 'deleteCaseDialogActionSecondary']");
    private static final By SECOND_DELETE_PERMANENTLY_BUTTON = By.xpath("//input[@id='isCasesBulkDeletion']/..//a[@data-testid ='deleteCaseDialogActionDefault']");
    private static final By CONFIRMATION_DIALOG = By.id("dialog-ident-casesDeletionDialog");
    private static final By SECOND_CONFIRMATION_DIALOG = By.id("dialog-ident-casesDeletionConfirmationDialog");

    public ConfirmationModalForTestCase(WebDriver driver) {
        super(driver);
    }


    @Step("Click Delete Permanently button on Confirmation")
    public void clickDeletePermanentlyButton() {
        new Button(driver, DELETE_PERMANENTLY_BUTTON).click();
    }

    @Step("Click Delete Permanently button on Confirmation")
    public void clickSecondDeletePermanentlyButton() {
        new Button(driver, SECOND_DELETE_PERMANENTLY_BUTTON).click();
    }

    @Step("Wait until the confirmation window appears")
    public void waitConfirmationDialogToTestCaseIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_DIALOG));
    }

    @Step("Wait until the second confirmation window appears")
    public void waitSecondConfirmationDialogToTestCaseIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SECOND_CONFIRMATION_DIALOG));
    }

}
