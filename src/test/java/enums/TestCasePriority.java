package enums;

import java.util.Arrays;

public enum TestCasePriority {
    CRITICAL("Critical"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");


    private final String name;

    TestCasePriority(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static TestCasePriority getFromName(String name) {
        return Arrays.stream(TestCasePriority.values())
                .filter(value -> value.getName().equals(name))
                .findFirst().orElse(null);
    }
}
