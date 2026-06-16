package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseRq {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("preconditions")
    @Expose
    private String preconditions;

    @SerializedName("postconditions")
    @Expose
    private String postconditions;

    @SerializedName("severity")
    @Expose
    private Integer severity;

    @SerializedName("priority")
    @Expose
    private Integer priority;
}
