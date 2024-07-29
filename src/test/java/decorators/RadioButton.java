package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class RadioButton extends ElementDecorator {
    public RadioButton(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public RadioButton(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public RadioButton(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void select() {
        if (!element.isSelected()) {
            log.debug("Clicking radiobutton,with data-testid = {}", this.dataTestId);
            element.click();
        }
    }
}
