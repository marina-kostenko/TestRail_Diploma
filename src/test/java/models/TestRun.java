package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;


@Builder(setterPrefix = "set")
@Data
public class TestRun {
    private String name;
    @SerializedName("milestone_id")
    private int milestoneId;
    @SerializedName("refs")
    private String references;
    private String description;
}
