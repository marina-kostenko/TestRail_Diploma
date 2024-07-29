package models;

import enums.Template;
import enums.TestCasePriority;
import enums.TestCaseStatus;
import enums.TestCaseType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder(setterPrefix = "set")
@Data
public class TestCase {
    private String title;
    @EqualsAndHashCode.Exclude
    private Template template;
    private TestCaseType type;
    private TestCasePriority priority;
    private TestCaseStatus status;
    private String assignedTo;
    private String preconditions;
    private String steps;
    private String expectedResult;
    private String stepDescription;
    private String stepsExpectedResult;
    private String estimateInput;

}
