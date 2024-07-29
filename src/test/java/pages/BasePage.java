package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());
    private static final By SUCCESS_MESSAGE = By.cssSelector("[data-testid = messageSuccessDivBox]");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public abstract void isPageOpened();

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_MESSAGE));
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }

}
