package pages;

import decorators.Button;
import decorators.Input;
import decorators.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Section;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddSectionPage extends BaseDashboardPage {
    private static final By SECTION_NAME = By.id("editSectionName");
    private static final By SECTION_DESCRIPTION = By.id("editSectionDescription_display");
    private static final By ADD_SECTION = By.id("editSectionSubmit");

    public AddSectionPage(WebDriver driver) {
        super(driver);
    }

    @Step("Creating new Section")
    public void createSection(Section section) {
        log.info("Creating Section - {}", section.getName());
        new Input(driver, SECTION_NAME).setValue(section.getName());
        new TextArea(driver, SECTION_DESCRIPTION).setValue(section.getDescription());
    }

    @Step("Click 'Add Section' button")
    public void clickAddSection() {
        new Button(driver, ADD_SECTION).click();
    }

    @Step("Editing new Section")
    public void editSection(Section section) {
        new Input(driver, SECTION_NAME).clearAndSetValue(section.getName());

    }
}
