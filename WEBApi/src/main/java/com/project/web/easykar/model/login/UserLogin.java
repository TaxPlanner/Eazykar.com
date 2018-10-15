/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.easykar.model.login;

/**
 *
 * @author manoj
 */
public class UserLogin {
    private String email;
    private String password;

    public UserLogin() {
    }

    
    public UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
