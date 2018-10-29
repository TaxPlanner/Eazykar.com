/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.easykar.logincontroller;

import com.google.gson.Gson;
import com.project.web.easykar.constant.VariableConstant;
import com.project.web.easykar.model.login.LoginResponse;
import com.project.web.easykar.model.login.UserLogin;
import com.project.web.easykar.model.registration.RegistrationResponse;
import com.project.web.easykar.model.registration.RegisterUser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author manoj
 */
@Controller
public class LoginController {

    VariableConstant valConstant = new VariableConstant();
    private String BASEURL = valConstant.BaseUrl;
    private String APILOGIN = valConstant.ApiLogin;
    private String APIREISTRATION = valConstant.ApiRegistration;
    
    @GetMapping("/")
    public String home3() {
        return "index";
    }

    @GetMapping("/register")
    public String home4() {
        return "register";
    }

    @GetMapping("/contact-us")
    public String contacts() {
        return "contact-us";
    }

    @GetMapping("/tax-knowledge")
    public String aboutus() {
        return "tax-knowledge";
    }

    @GetMapping("/it-return-services")
    public String itretrnservices() {
        return "it-return-services";
    }

    // Return registration form template
    @RequestMapping(value = "/user_register", method = RequestMethod.POST)
    public String showHomePage(WebRequest request, Model model, RegisterUser userReg) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        try {
            json.put("email", userReg.getEmail());
            json.put("password", userReg.getPassword());
            json.put("usertype", "User");
            json.put("ipaddress", "127.0.0.1");
            json.put("operatingsyatem", "web");
            json.put("createdon", "2018-10-12");
            json.put("status", "1");
        } catch (JSONException ex) {
           
        }
        HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(), httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        try {
            String res = restTemplate.postForObject(BASEURL+APIREISTRATION, httpEntity, String.class);
            Gson gson = new Gson();
            RegistrationResponse response = gson.fromJson(res.toString(), RegistrationResponse.class);
            if (response.getResponseCode().equalsIgnoreCase("1")) {
                return "redirect:home";
            } else {
                return "redirect:/register";
            }
        } catch (Exception e) {
            return "redirect:/register";
        }
    }

    // Return registration form template
    @RequestMapping(value = "/user_login", method = RequestMethod.POST)
    public String showHomePage2(WebRequest request, Model model, UserLogin reqLogin) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        try {
            json.put("email", reqLogin.getEmail());
            json.put("password", reqLogin.getPassword());
        } catch (JSONException ex) {
            
        }
        HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(), httpHeaders);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String res = restTemplate.postForObject(BASEURL+APILOGIN, httpEntity, String.class);
            Gson gson = new Gson();
            LoginResponse response = gson.fromJson(res.toString(), LoginResponse.class);
            if (response.getResponseCode().equalsIgnoreCase("1")) {
                return "redirect:home";
            } else {
                return "redirect:/register";
            }
        } catch (Exception e) {
            return "redirect:/register";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }
}
