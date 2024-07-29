package utils;

import com.github.javafaker.Faker;
import enums.*;
import models.*;

public class TestDataGeneration {
    static Faker faker = new Faker();

    public static Project generateProject() {

        return Project.builder()
                .setName(faker.country().name() + faker.number().randomDigit())
                .setShowAnnouncement(true)
                .setAnnouncement(faker.address().cityName())
                .setProjectType(ProjectType.SINGLE_REPO_FOR_ALL_CASES)
                .setEnableTestCaseApprovals(true)
                .setSuiteMode(1)
                .setCaseStatusesEnabled(true)
                .build();
    }

    public static Project generateProjectWithoutName()
    {
        return Project.builder()
                .setName("")
                .setShowAnnouncement(true)
                .setAnnouncement(faker.address().cityName())
                .setProjectType(ProjectType.SINGLE_REPO_FOR_ALL_CASES)
                .setEnableTestCaseApprovals(true)
                .build();
    }

    public static Project generateUpdateProject()
    {
        return Project.builder()
                .setName(faker.funnyName().name())
                .setShowAnnouncement(true)
                .setAnnouncement(faker.address().countryCode())
                .build();
    }


    public static TestCase generateTestCase() {

        return TestCase.builder()
                .setTitle(faker.animal().name() + faker.number().randomDigit())
                .setTemplate(Template.TEST_CASE_TEXT)
                .setType(TestCaseType.COMPATIBILITY)
                .setPriority(TestCasePriority.CRITICAL)
                .setStatus(TestCaseStatus.DESIGN)
                .setPreconditions("Preconditions")
                .setSteps("Steps")
                .setExpectedResult("Expected result")
                .build();
    }

    public static TestCase generateTestCaseSteps()
    {
        return TestCase.builder()
                .setTitle(faker.animal().name() + faker.number().randomDigit())
                .setTemplate(Template.TEST_CASE_STEPS)
                .setType(TestCaseType.FUNCTIONAL)
                .setPriority(TestCasePriority.MEDIUM)
                .setStatus(TestCaseStatus.READY)
                .setPreconditions("Preconditions")
                .setStepDescription("Step_1")
                .setStepsExpectedResult("Expected result_1")
                .build();
    }


    public static TestCase generateEditTestCaseSteps() {
        return TestCase.builder()
                .setTitle(faker.color().name() + faker.number().randomDigit())
                .setTemplate(Template.TEST_CASE_STEPS)
                .setType(TestCaseType.COMPATIBILITY)
                .setPriority(TestCasePriority.CRITICAL)
                .setStatus(TestCaseStatus.DESIGN)
                .setPreconditions("Preconditions")
                .setStepDescription("Step_1")
                .setStepsExpectedResult("Expected result_1")
                .build();
    }

    public static Milestone generateUpdateMilestone()
    {
        return Milestone.builder()
                .setName(faker.color().name() + faker.number().randomDigit())
                .setReferences("New References")
                .setDescription("New Description")
                .setStartDate("10/16/2024")
                .setEndDate("10/30/2024")
                .setMilestoneIsCompleted(true)
                .build();
    }

    public static Milestone generateMilestone()
    {
        return Milestone.builder()
                .setName(faker.color().name() + faker.number().randomDigit())
                .setReferences("References")
                .setDescription("Description")
                .setStartDate("6/18/2024")
                .setEndDate("6/30/2024")
                .setMilestoneIsCompleted(true)
                .build();
    }

    public static Section generateSection()
    {
        return Section.builder()
                .setName("Section" + faker.number().randomDigit())
                .setDescription("Description for section 12345")
                .build();
    }


    public static Section generateEditSection() {
        return Section.builder()
                .setName("Section_EDIT" + faker.color().name())
                .build();
    }

    public static TestCase generateUpdateTestCase() {
        return TestCase.builder()
                .setTitle(faker.animal().name() + faker.number().randomDigit())
                .setType(TestCaseType.ACCEPTANCE)
                .setPriority(TestCasePriority.MEDIUM)
                .setStatus(TestCaseStatus.REVIEW)
                .setPreconditions("New Preconditions")
                .setSteps("New Steps")
                .setExpectedResult("New Expected result")
                .build();
    }
    public static TestCase generateInvalidEstimateTestCase()
    {
        return TestCase.builder()
                .setTitle(faker.animal().name() + faker.number().randomDigit())
                .setTemplate(Template.TEST_CASE_TEXT)
                .setType(TestCaseType.COMPATIBILITY)
                .setPriority(TestCasePriority.CRITICAL)
                .setStatus(TestCaseStatus.DESIGN)
                .setEstimateInput("twenty")
                .setPreconditions("Preconditions")
                .setSteps("Steps").setExpectedResult("Expected result")
                .build();
    }

    public static Project generateInvalidReferenciesProject()
    {
        return Project.builder()
                .setName(faker.country().name() + faker.number().randomDigit())
                .setReferences("References")
                .build();
    }
    public static Milestone generateSimpleMilestone()
    {
        return Milestone.builder()
                .setName(faker.color().name() + faker.number().randomDigit())
                .setReferences("References")
                .setDescription("Description")
                .setMilestoneIsCompleted(true)
                .build();
    }

    public static TestRun generateTestRun(int milestoneId)
    {
        return TestRun.builder()
                .setName(faker.color().name() + faker.number().randomDigit())
                .setReferences("References Of TestRun")
                .setMilestoneId(milestoneId)
                .setDescription("Description of TestRun")
                .build();
    }
}