/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.model.registration;

/**
 *
 * @author manoj
 */
public class FailLoginResponse {
    private String response_code;
    private String response_msg;
    private EmptyJsonResponse Login_result;

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

    public EmptyJsonResponse getLogin_result() {
        return Login_result;
    }

    public void setLogin_result(EmptyJsonResponse Login_result) {
        this.Login_result = Login_result;
    }

    
}
