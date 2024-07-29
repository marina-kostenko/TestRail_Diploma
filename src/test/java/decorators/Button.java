package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends ElementDecorator {
    public Button(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Button(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public Button(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }
}
