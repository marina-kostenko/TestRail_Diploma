package enums;

import java.util.Arrays;

public enum TestCaseType {
    OTHER("Other"),
    ACCEPTANCE("Acceptance"),
    ACCESSIBILITY("Accessibility"),
    AUTOMATED("Automated"),
    COMPATIBILITY("Compatibility"),
    DESTRUCTIVE("Destructive"),
    FUNCTIONAL("Functional"),
    PERFORMANCE("Performance"),
    REGRESSION("Regression"),
    SECURITY("Security"),
    SMOKE("Smoke"),
    USABILITY("Usability");

    private final String name;

    TestCaseType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static TestCaseType getFromName(String name) {
        return Arrays.stream(TestCaseType.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
