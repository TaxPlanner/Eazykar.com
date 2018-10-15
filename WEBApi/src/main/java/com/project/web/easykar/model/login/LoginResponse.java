package com.project.web.easykar.model.login;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse implements Serializable
{

    @SerializedName("response_code")
    @Expose
    private String responseCode;
    @SerializedName("response_msg")
    @Expose
    private String responseMsg;
    @SerializedName("login_result")
    @Expose
    private LoginResult loginResult;
    private final static long serialVersionUID = 2730490246171731498L;

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

    public LoginResult getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(LoginResult loginResult) {
        this.loginResult = loginResult;
    }

}
