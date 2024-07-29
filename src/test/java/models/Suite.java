package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Suite {
    String name;
    String description;
}
