
package com.project.web.easykar.model.profile;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse implements Serializable
{

    @SerializedName("response_code")
    @Expose
    private String responseCode;
    @SerializedName("response_msg")
    @Expose
    private String responseMsg;
    private final static long serialVersionUID = 2666062581261179278L;

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

}
