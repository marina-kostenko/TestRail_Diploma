package pages;

import decorators.Button;
import decorators.ElementDecorator;
import decorators.Input;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

import java.util.List;

public class LoginPage extends BasePage {
    private static final String EMAIL = "loginIdName";
    private static final String PASSWORD = "loginPasswordFormDialog";
    private static final String LOGIN_BUTTON = "loginButtonPrimary";
    private static final By ERROR_MESSAGE = By.cssSelector("[data-testid = loginErrorText]");
    private static final By ERROR_MESSAGE_NEAR_FIELD = By.cssSelector(".loginpage-message");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(new Button(driver, LOGIN_BUTTON)));
    }

    public void open() {
        driver.navigate().to(PropertyReader.getProperty("base_url"));
    }

    @Step("Fill login form email: '{email}' and password: '{password}'")
    public void login(String email, String password) {
        logger.info("Log in with email: '{}' and password: '{}'", email ,password);
        new Input(driver, EMAIL).setValue(email);
        new Input(driver, PASSWORD).setValue(password);
        new ElementDecorator(driver, LOGIN_BUTTON).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    public boolean isErrorMessageNearTheFieldDisplayed() {
        return driver.findElement(ERROR_MESSAGE_NEAR_FIELD).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getErrorMessageNearTheFieldText() {
        return driver.findElement(ERROR_MESSAGE_NEAR_FIELD).getText();
    }

    @Step("Get list with all errors near fields")
    public List<String> getErrors() {
        List<WebElement> errors = driver.findElements(ERROR_MESSAGE_NEAR_FIELD);
        return errors.stream()
                .map(WebElement::getText)
                .toList();
    }

}
