package models;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder(setterPrefix = "set")
@Data
public class Milestone {
    private String name;
    @EqualsAndHashCode.Exclude
    @SerializedName("refs")
    private String references;
    private String description;
    private String startDate;
    @EqualsAndHashCode.Exclude
    private String endDate;
    @EqualsAndHashCode.Exclude
    @SerializedName("is_completed")
    private boolean milestoneIsCompleted;


}
