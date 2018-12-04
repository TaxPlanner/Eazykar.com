package com.easykar.rest.userprofile;

import com.easykar.rest.model.registration.EmptyJsonResponse;

public class GetProfileFailResponse {
    private String response_code;
    private String response_msg;
    private EmptyJsonResponse Profile_result;
    
    public String getResponse_code() {
        return response_code;
    }
    
    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }
    
    public String getResponse_msg() {
        return response_msg;
    }
    
    public void setResponse_msg(String response_msg) {
        this.response_msg = response_msg;
    }
    
    public EmptyJsonResponse getProfile_result() {
        return Profile_result;
    }
    
    public void setProfile_result(EmptyJsonResponse Login_result) {
        this.Profile_result = Login_result;
    }
}
