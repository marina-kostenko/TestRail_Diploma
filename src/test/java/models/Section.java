package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder(setterPrefix = "set")
@Data
public class Section {
    String name;
    String description;
    @EqualsAndHashCode.Exclude
    @SerializedName("suite_id")
    Integer suiteId;
}
