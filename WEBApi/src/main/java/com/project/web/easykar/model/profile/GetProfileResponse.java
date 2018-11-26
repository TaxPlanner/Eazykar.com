
package com.project.web.easykar.model.profile;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProfileResponse implements Serializable
{

    @SerializedName("response_code")
    @Expose
    private String responseCode;
    @SerializedName("response_msg")
    @Expose
    private String responseMsg;
    @SerializedName("profile_result")
    @Expose
    private ProfileResult profileResult;
    private final static long serialVersionUID = -8677498761221314531L;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public ProfileResult getProfileResult() {
        return profileResult;
    }

    public void setProfileResult(ProfileResult profileResult) {
        this.profileResult = profileResult;
    }

}
