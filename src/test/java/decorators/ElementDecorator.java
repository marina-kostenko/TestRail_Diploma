package decorators;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ElementDecorator implements WebElement {
    protected WebDriver driver;
    protected WebElement element;
    protected By locator;
    protected String dataTestId;

    public ElementDecorator(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }

    public ElementDecorator(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        this.element = driver.findElement(locator);
    }

    public ElementDecorator(WebDriver driver, String dataTestId) {
        this.driver = driver;
        this.dataTestId = dataTestId;
        this.element = driver.findElement(By.cssSelector(String.format("[data-testid = %s]", this.dataTestId)));
    }

    public ElementDecorator findElementDecorator(By locator) {
        return new ElementDecorator(this.driver, locator);
    }

    public List<ElementDecorator> findElementsDecorator(By locator) {
        List<ElementDecorator> result = new ArrayList<>();
        for (WebElement elements : element.findElements(locator)) {
            result.add(new ElementDecorator(driver, elements));
        }
        return result;
    }

    public void scrollIntoView() {
        ((JavascriptExecutor) this.driver).
                executeScript("arguments[0].scrollIntoView(true);", this.element);
    }

    @Override
    public void click() {
        try {
            log.debug("Clicking on element with data-testid = {}",this.dataTestId);
            element.click();
        } catch (ElementNotInteractableException e) {
            log.debug("Scrolling before click");
            scrollIntoView();
            log.debug("Clicking on element with data-testid = {}",this.dataTestId);
            element.click();
        }
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }
    public void clearAndSetValue(CharSequence... keysToSend)
    {
        element.clear();
        log.debug("Setting value = {} into element with data-testid = {}", keysToSend, this.dataTestId);
        element.sendKeys(keysToSend);

    }
}
