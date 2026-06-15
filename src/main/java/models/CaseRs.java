package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CaseRs {

    @SerializedName("status")
    @Expose
    public Boolean status;

    @SerializedName("result")
    @Expose
    public CaseResult result;
}
