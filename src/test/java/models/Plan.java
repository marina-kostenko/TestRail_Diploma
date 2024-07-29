package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
public class Plan {
    String name;
    String description;
    @SerializedName("milestone_id")
    int milestoneId;
    @EqualsAndHashCode.Exclude
    String refs;
}

