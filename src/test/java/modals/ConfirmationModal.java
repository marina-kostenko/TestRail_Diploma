package modals;

import decorators.Button;
import decorators.CheckBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationModal extends BaseModal {

    private static final String OK_BUTTON = "caseFieldsTabDeleteDialogButtonOk";
    private static final By CONFIRMATION_DIALOG = By.id("dialog-ident-deleteDialog");

    private static final By CHECK_BOX = By.xpath("//div[@id='dialog-ident-deleteDialog']//input[@data-testid = 'deleteCheckBoxTestId']");
    private static final String CANCEL_BUTTON = "caseFieldsTabDeleteDialogButtonOk";

    public ConfirmationModal(WebDriver driver) {
        super(driver);
    }

    @Step("Click Ok button on Confirmation")
    public void clickDeleteButton() {
        new Button(driver, OK_BUTTON).click();
    }

    @Step("Wait until the confirmation window appears")
    public void waitConfirmationDialogToDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRMATION_DIALOG));
    }

    @Step("Checking confirm delete checkbox")
    public void checkCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(CHECK_BOX));
        new CheckBox(driver, CHECK_BOX).check();
    }

    @Step("Click Cancel button on Confirmation")
    public void clickCancelButton() {
        new Button(driver, CANCEL_BUTTON).click();
    }

}
