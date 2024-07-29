package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@Log4j2
public class Input extends ElementDecorator {
    public Input(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Input(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public Input(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public String getValue() {
        return this.element.getAttribute("value");
    }

    public void clearValue() {
        element.clear();
    }

    public void setValue(CharSequence... keysToSend) {
        log.debug("Setting value = {} into element (input) with data-testid = {}", keysToSend, this.dataTestId);
        element.sendKeys(keysToSend);
    }
}
