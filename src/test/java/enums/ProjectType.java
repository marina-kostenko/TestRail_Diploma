package enums;

public enum ProjectType {
    SINGLE_REPO_FOR_ALL_CASES("addEditProjectSuiteModeSingle", "Use a single repository for all cases (recommended)"),
    SINGLE_REPO_WITH_BASELINE("addEditProjectSuiteModeSingleBaseline", "Use a single repository with baseline support"),
    MULTIPLE_TEST_SUITES("addEditProjectSuiteModeMulti", "Use multiple test suites to manage cases");

    private final String id;
    private final String name;

    ProjectType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
