package com.project.web.easykar.model.registration;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationResponse implements Serializable
{

    @SerializedName("response_code")
    @Expose
    private String responseCode;
    @SerializedName("response_msg")
    @Expose
    private String responseMsg;
    @SerializedName("registration_result")
    @Expose
    private RegistrationResult registrationResult;
    private final static long serialVersionUID = 1729952355100320622L;

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

    public RegistrationResult getRegistrationResult() {
        return registrationResult;
    }

    public void setRegistrationResult(RegistrationResult registrationResult) {
        this.registrationResult = registrationResult;
    }

}
