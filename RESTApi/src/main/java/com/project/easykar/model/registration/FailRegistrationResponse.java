/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.model.registration;

import com.google.gson.JsonObject;

/**
 *
 * @author manoj
 */
public class FailRegistrationResponse {
    private String response_code;
    private String response_msg;
    private EmptyJsonResponse registration_result;

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

    public EmptyJsonResponse getRegistration_result() {
        return registration_result;
    }

    public void setRegistration_result(EmptyJsonResponse registration_result) {
        this.registration_result = registration_result;
    }

    
    
}
