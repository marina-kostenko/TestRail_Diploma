package pages;

import decorators.Button;
import decorators.CheckBox;
import decorators.Input;
import decorators.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AddMilestonePage extends BaseDashboardPage {
    private static final String MILESTONE_NAME = "addEditMilestoneName";
    private static final String MILESTONE_REFERENCE = "addEditMilestoneReference";
    private static final String MILESTONE_DESCRIPTION = "editSectionDescription";
    private static final String MILESTONE_CHECK_BOX = "addEditMilestoneIsCompleted";
    private static final String MILESTONE_CREATE_BUTTON = "milestoneButtonOk";
    private static final String MILESTONE_START_DATE = "addEditMilestoneStartOn";
    private static final String MILESTONE_END_DATE = "addEditMilestoneDueOn";
    private static final By ERROR_MESSAGE = By.cssSelector("div + .message-error");

    public AddMilestonePage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isPageOpened()
    {
        wait.until(ExpectedConditions.visibilityOf(new Button(driver, MILESTONE_CREATE_BUTTON)));
    }

    @Step("Create new milestone")
    public void createMilestone(Milestone milestone)
    {
        log.info("Creating Milestone)- {}", milestone.getName());
        new Input(driver, MILESTONE_NAME).setValue(milestone.getName());
        new Input(driver, MILESTONE_REFERENCE).setValue(milestone.getReferences());
        new TextArea(driver, MILESTONE_DESCRIPTION).setValue(milestone.getDescription());
        new Input(driver, MILESTONE_START_DATE).setValue(milestone.getStartDate());
        new Input(driver, MILESTONE_END_DATE).setValue(milestone.getEndDate());
        new CheckBox(driver, MILESTONE_CHECK_BOX).check();
    }

    @Step("Create new milestone without name")
    public void createMilestoneWithoutName(Milestone milestone)
    {
        new Input(driver, MILESTONE_NAME).setValue(milestone.getName());
        new CheckBox(driver, MILESTONE_CHECK_BOX).check();
    }

    @Step("Click 'Create milestone' button")
    public void clickCreateMilestoneButton()
    {
        new Button(driver, MILESTONE_CREATE_BUTTON).click();
    }

    public String getErrorMessage()
    {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Edit milestone")
    public void editMilestone(Milestone milestone)
    {
        new Input(driver, MILESTONE_NAME).clearAndSetValue(milestone.getName());

        new Input(driver, MILESTONE_REFERENCE).clearAndSetValue(milestone.getReferences());

        new TextArea(driver, MILESTONE_DESCRIPTION).clearAndSetValue(milestone.getDescription());

        new Input(driver, MILESTONE_START_DATE).clearAndSetValue(milestone.getStartDate());

        new Input(driver, MILESTONE_END_DATE).clearAndSetValue(milestone.getEndDate());

        new CheckBox(driver, MILESTONE_CHECK_BOX).check();
    }
}
