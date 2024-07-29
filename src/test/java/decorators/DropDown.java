package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class DropDown extends ElementDecorator {
    private final By expandButton = By.cssSelector("[data-testid='historyCompareToButton']");
    private final By searchInput = By.cssSelector("input[type='text']");
    private final By options = By.cssSelector("ul.chzn-results li");

    public DropDown(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public void selectByVisibleText(String value) {
        expand();
        WebElement option = this.getOptionByText(value);
        try {
            log.debug("Select option {}", value);
            option.click();
        } catch (ElementNotInteractableException exception) {
            setSearchValue(value);
            log.debug("Select option {}", value);
            option.click();
        }

    }
    public void setSearchValue(String value) {
        element.findElement(searchInput).sendKeys(value);

    }
    private void expand() {
        element.findElement(expandButton).click();
    }

    private WebElement getOptionByText(String value) {
        return this.getAllOptions().stream().filter(opt -> opt.getText().equals(value)).findFirst().orElse(null);
    }
    private List<WebElement> getAllOptions() {
        return element.findElements(options);
    }

}
