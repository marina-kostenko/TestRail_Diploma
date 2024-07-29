package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class TextArea extends ElementDecorator {
    public TextArea(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public TextArea(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public TextArea(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void setValue(CharSequence... keysToSend) {
        log.debug("Setting value = {} into text area with data-testid = {}", keysToSend, this.dataTestId);
        element.sendKeys(keysToSend);
    }
    public void clearValue() {
        element.clear();
    }
}
