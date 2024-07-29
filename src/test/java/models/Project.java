package models;

import com.google.gson.annotations.SerializedName;
import enums.ProjectType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Builder(setterPrefix = "set")
@Data
public class Project {
    private String name;
    private String announcement;

    @EqualsAndHashCode.Exclude
    @SerializedName("show_announcement")
    private boolean showAnnouncement;
    @EqualsAndHashCode.Exclude
    private ProjectType projectType;
    @EqualsAndHashCode.Exclude
    private boolean enableTestCaseApprovals;
    @EqualsAndHashCode.Exclude
    private String references;
    @EqualsAndHashCode.Exclude
    @SerializedName("suite_mode")
    private int suiteMode;
    @EqualsAndHashCode.Exclude
    @SerializedName("case_statuses_enabled")
    private boolean caseStatusesEnabled;


}

