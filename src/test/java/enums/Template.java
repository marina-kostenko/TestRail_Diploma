package enums;

public enum Template {
    BEHAVIOUR_DRIVEN_DEVELOPMENT("Behaviour Driven Development"),
    EXPLORATORY_SESSION("Exploratory Session"),
    TEST_CASE_STEPS("Test Case (Steps)"),
    TEST_CASE_TEXT("Test Case (Text)");


    private final String name;

    Template(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}