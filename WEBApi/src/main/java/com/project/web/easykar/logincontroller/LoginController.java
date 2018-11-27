/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.easykar.logincontroller;

import com.google.gson.Gson;
import com.project.web.easykar.constant.VariableConstant;
import com.project.web.easykar.global.Utility;
import com.project.web.easykar.model.login.LoginResponse;
import com.project.web.easykar.model.login.UserLogin;
import com.project.web.easykar.model.profile.GetProfileResponse;
import com.project.web.easykar.model.registration.RegistrationResponse;
import com.project.web.easykar.model.registration.RegisterUser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    private String APIREGISTRATION = valConstant.ApiRegistration;
    private String URLGETPROFILE = valConstant.ApiGetProfile;
    private GetProfileResponse response2;
    @Autowired
    private Utility utility;

    @GetMapping("/")
    public String home3(Model model) {
        model.addAttribute("message", "This is welcome page!");
        utility.setResGetProfileResponse(null);
        utility.setResRegistration(null);
        utility.setResLogin(null);
        utility.setIsLoin(false);
        utility.setIsEditProfile(false);
        utility.setIsRegister(false);
        utility.setIsProfile(false);
        utility.setIsFiles(false);
        utility.setIsPlan(false);
        utility.setIsLoginActive(true);
        utility.setIsRegistrationActive(false);
        utility.setMsgLoginError("");
        utility.setMsgRegistrationError("");
        return "index";
    }

    @GetMapping("/signin")
    public String home4(Model model) {
        System.out.println("1/"+utility.getIsRegistrationActive()+"/"+utility.getIsLoginActive());
        model.addAttribute("msgRegistrationError", utility.getMsgRegistrationError());
        model.addAttribute("msgLoginError", utility.getMsgLoginError());
        model.addAttribute("activeRegistration", utility.getIsRegistrationActive());
        model.addAttribute("activeLogin", utility.getIsLoginActive());
        return "signin";
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
         utility.setIsLoginActive(false);
         utility.setIsRegistrationActive(true);
         
         System.out.println("2/"+utility.getIsRegistrationActive()+"/"+utility.getIsLoginActive());
        if(!userReg.getPassword().toString().toLowerCase().equalsIgnoreCase(userReg.getRepassword())){
            utility.setMsgRegistrationError("Please check password and confirm password.");
           
            utility.setIsLoginActive(false);
            utility.setIsRegistrationActive(true);
            return "redirect:/signin";
        }
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
            utility.setIsLoginActive(false);
            utility.setIsRegistrationActive(true);
            return "redirect:/signin";
        }
        HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(), httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        try {
            String res = restTemplate.postForObject(BASEURL + APIREGISTRATION, httpEntity, String.class);
            Gson gson = new Gson();
            RegistrationResponse response = gson.fromJson(res.toString(), RegistrationResponse.class);
            utility.setResRegistration(response);
            if (response.getResponseCode().equalsIgnoreCase("1")) {
                utility.setIsRegister(true);
                utility.setMsgRegistrationError("");
               // model.addAttribute("isProfile", true);
                return "redirect:/userdashboard";
            } else {
                utility.setMsgRegistrationError("Some error occured. Please try again.");
                utility.setIsRegister(false);
                utility.setIsLoginActive(false);
                utility.setIsRegistrationActive(true);
                return "redirect:/signin";
            }
        } catch (Exception e) {
            utility.setMsgRegistrationError("Some error occured. Please try again.");
            utility.setIsRegister(false);
            utility.setIsLoginActive(false);
            utility.setIsRegistrationActive(true);
            return "redirect:/signin";
        }
    }

    // Return registration form template
    @RequestMapping(value = "/userdashboard", method = RequestMethod.POST)
    public String showHomePage2(WebRequest request, Model model, UserLogin reqLogin) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        try {
            json.put("email", reqLogin.getEmail());
            json.put("password", reqLogin.getPassword());
        } catch (JSONException ex) {
            utility.setMsgLoginError("Some error occured. Please try again.");
            return "redirect:/signin";
        }
        //  model.addAttribute("person", "Manoj");
        HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(), httpHeaders);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String res = restTemplate.postForObject(BASEURL + APILOGIN, httpEntity, String.class);
            Gson gson = new Gson();
            LoginResponse response = gson.fromJson(res.toString(), LoginResponse.class);
            utility.setResLogin(response);
            System.out.println("ID >>>>>>"+response.getLoginResult().getId());
            
            if (response.getResponseCode().equalsIgnoreCase("1")) {
                utility.setIsLoin(true);
                utility.setMsgLoginError("");
                HttpHeaders httpHeaders2 = new HttpHeaders();
                httpHeaders.set("Content-Type", "application/json");
                JSONObject jsonCreate = new JSONObject();
                jsonCreate.put("userID", response.getLoginResult().getId());
                System.out.println("JSON >>>>>>"+jsonCreate.toString());
                HttpEntity<String> httpEntity2 = new HttpEntity<String>(jsonCreate.toString(), httpHeaders);
                RestTemplate restTemplate2 = new RestTemplate();
                String res2 = restTemplate.postForObject(BASEURL + URLGETPROFILE, httpEntity2, String.class);
                Gson gson2 = new Gson();
                response2 = gson2.fromJson(res2.toString(), GetProfileResponse.class);
                utility.setResGetProfileResponse(response2);
                System.out.println("RES  >>>>>>"+response2.getProfileResult().getFirstName());
                if (response2.getResponseCode().equalsIgnoreCase("1")) {
                    model.addAttribute("isProfile", true);
                    model.addAttribute("firstName", response2.getProfileResult().getFirstName());
                    model.addAttribute("middleName", response2.getProfileResult().getMiddleName());
                    model.addAttribute("lastName", response2.getProfileResult().getLastName());
                    model.addAttribute("mobileNo", response2.getProfileResult().getMobile());
                    model.addAttribute("DOB", response2.getProfileResult().getDob());
                    model.addAttribute("panNo", response2.getProfileResult().getPanNumber());
                    model.addAttribute("address", response2.getProfileResult().getAddress());
                }
                return "/userdashboard";
            } else {
                utility.setIsLoin(false);
                utility.setMsgLoginError("Please check username and password.");
                utility.setIsLoginActive(true);
                utility.setIsRegistrationActive(false);
                return "redirect:/signin";
            }
        } catch (Exception e) {
            utility.setIsLoin(false);
            utility.setMsgLoginError("Some error occured. Please try again.");
            utility.setIsLoginActive(true);
            utility.setIsRegistrationActive(false);
            return "redirect:/signin";
        }
    }

    @GetMapping("/userdashboard")
    public String home(Model model) {
        model.addAttribute("msgDocumentSuccess", utility.getMsgDocumentSuccess());
        model.addAttribute("isProfile", utility.getIsProfile());
        model.addAttribute("isFiles", utility.getIsFiles());
        model.addAttribute("isPlan", utility.getIsPlan());
        model.addAttribute("msgProfileSuccess", utility.getMsgProfileSuccess());
        if(utility.getResGetProfileResponse() != null){
            if (utility.getResGetProfileResponse().getResponseCode().equalsIgnoreCase("1")) {
                model.addAttribute("firstName", utility.getResGetProfileResponse().getProfileResult().getFirstName());
                model.addAttribute("middleName", utility.getResGetProfileResponse().getProfileResult().getMiddleName());
                model.addAttribute("lastName", utility.getResGetProfileResponse().getProfileResult().getLastName());
                model.addAttribute("mobileNo", utility.getResGetProfileResponse().getProfileResult().getMobile());
                model.addAttribute("DOB", utility.getResGetProfileResponse().getProfileResult().getDob());
                model.addAttribute("panNo", utility.getResGetProfileResponse().getProfileResult().getPanNumber());
                model.addAttribute("address", utility.getResGetProfileResponse().getProfileResult().getAddress());
            }
        }
        return "/userdashboard";
    }
    
    @GetMapping("/user_register")
    public String home22(Model model) {
        System.out.println("3/"+utility.getIsRegistrationActive()+"/"+utility.getIsLoginActive());
        model.addAttribute("activeRegistration", utility.getIsRegistrationActive());
        model.addAttribute("activeLogin", utility.getIsLoginActive());
        return "redirect:/signin";
    }
    
    @GetMapping("/profile/create_update")
    public String home2(Model model) {
         model.addAttribute("isProfile", utility.getIsProfile());
        model.addAttribute("isFiles", utility.getIsFiles());
        model.addAttribute("isPlan", utility.getIsPlan());
        model.addAttribute("msgProfileSuccess", utility.getMsgProfileSuccess());
        if (utility.getResGetProfileResponse().getResponseCode().equalsIgnoreCase("1")) {
            model.addAttribute("firstName", utility.getResGetProfileResponse().getProfileResult().getFirstName());
            model.addAttribute("middleName", utility.getResGetProfileResponse().getProfileResult().getMiddleName());
            model.addAttribute("lastName", utility.getResGetProfileResponse().getProfileResult().getLastName());
            model.addAttribute("mobileNo", utility.getResGetProfileResponse().getProfileResult().getMobile());
            model.addAttribute("DOB", utility.getResGetProfileResponse().getProfileResult().getDob());
            model.addAttribute("panNo", utility.getResGetProfileResponse().getProfileResult().getPanNumber());
            model.addAttribute("address", utility.getResGetProfileResponse().getProfileResult().getAddress());
        }
        return "/userdashboard";
    }
}
