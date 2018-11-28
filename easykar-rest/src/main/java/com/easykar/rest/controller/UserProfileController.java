/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easykar.rest.controller.entity.UserProfile;
import com.easykar.rest.model.profile.GetProfileByID;
import com.easykar.rest.model.profile.GetProfileFailResponse;
import com.easykar.rest.model.profile.GetProfileResponse;
import com.easykar.rest.model.profile.ResponseProfileSuccess;
import com.easykar.rest.model.registration.EmptyJsonResponse;
import com.easykar.rest.service.UserProfileService;

@Controller
@RequestMapping(value = { "/profile" })
public class UserProfileController {
    
    @Autowired
    UserProfileService userProfileService;
    
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {
            "application/json",
            "application/xml" })
    public ResponseEntity<?> addProfile(@RequestBody UserProfile profile) {
        ResponseProfileSuccess regRes = new ResponseProfileSuccess();
        try {
            
            UserProfile getProfile = userProfileService.findByuserid(profile.getUserid());
            
            if (getProfile == null) {
                boolean isSave = userProfileService.save(profile);
                if (isSave) {
                    regRes.setResponse_code("1");
                    regRes.setResponse_msg("User profile has been saved successfully");
                    return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
                } else {
                    regRes.setResponse_code("0");
                    regRes.setResponse_msg("User profile has been failed");
                    return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
                }
                
            } else {
                boolean isUpdate = userProfileService.updateProfile(profile);
                if (isUpdate) {
                    regRes.setResponse_code("1");
                    regRes.setResponse_msg("User profile has been updated successfully");
                    return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
                } else {
                    regRes.setResponse_code("0");
                    regRes.setResponse_msg("User profile has been failed");
                    return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
                }
                
            }
            
        } catch (Exception e) {
            regRes.setResponse_code("0");
            regRes.setResponse_msg("User profile has been failed");
            return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
        }
        
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = { "application/json",
            "application/xml" }, consumes = { "application/json", "application/xml" })
    public ResponseEntity<?> getProfile(@RequestBody GetProfileByID profile) {
        GetProfileResponse regRes = new GetProfileResponse();
        GetProfileFailResponse regResFail = new GetProfileFailResponse();
        UserProfile getProfile = userProfileService.findByuserid(profile.getUserID());
        if (getProfile == null) {
            regResFail.setResponse_code("0");
            regResFail.setResponse_msg("Profile not found");
            regResFail.setProfile_result(new EmptyJsonResponse());
            return new ResponseEntity<GetProfileFailResponse>(regResFail, HttpStatus.CREATED);
            
        } else {
            regRes.setResponse_code("1");
            regRes.setResponse_msg("Profile found");
            regRes.setProfile_result(getProfile);
            return new ResponseEntity<GetProfileResponse>(regRes, HttpStatus.CREATED);
        }
    }
}
