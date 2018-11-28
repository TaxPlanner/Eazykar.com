/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.model.profile;

import com.easykar.rest.controller.entity.UserProfile;

/**
 *
 * @author manoj
 */
public class GetProfileResponse {
     private String response_code;
    private String response_msg;
    private UserProfile profile_result;

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

    public UserProfile getProfile_result() {
        return profile_result;
    }

    public void setProfile_result(UserProfile profile_result) {
        this.profile_result = profile_result;
    }
    
}
