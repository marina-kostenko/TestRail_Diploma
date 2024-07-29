package enums;

import java.util.Arrays;

public enum TestCaseStatus {
    READY("Ready"),
    DESIGN("Design"),
    REVIEW("Review");

    private final String name;

    TestCaseStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static TestCaseStatus getFromName(String name) {
        return Arrays.stream(TestCaseStatus.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
