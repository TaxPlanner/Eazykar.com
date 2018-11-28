package com.easykar.rest.userprofile;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easykar.rest.model.registration.EmptyJsonResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profile")
public class UserProfileController {
    
    private final UserProfileService userProfileService;
    
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {
            "application/json",
            "application/xml" })
    public ResponseEntity<?> addUserProfile(@RequestBody UserProfile profile) {
        ResponseProfileSuccess regRes = new ResponseProfileSuccess();
        try {
    
            UserProfile getProfile = userProfileService.findByUserId(profile.getUserid());
            
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
    public ResponseEntity<?> getUserProfile(@RequestBody GetProfileByID profile) {
        GetUserProfileResponse regRes = new GetUserProfileResponse();
        GetProfileFailResponse regResFail = new GetProfileFailResponse();
        UserProfile getProfile = userProfileService.findByUserId(profile.getUserID());
        if (getProfile == null) {
            regResFail.setResponse_code("0");
            regResFail.setResponse_msg("Profile not found");
            regResFail.setProfile_result(new EmptyJsonResponse());
            return new ResponseEntity<GetProfileFailResponse>(regResFail, HttpStatus.CREATED);
            
        } else {
            regRes.setResponse_code("1");
            regRes.setResponse_msg("Profile found");
            regRes.setProfile_result(getProfile);
            return new ResponseEntity<GetUserProfileResponse>(regRes, HttpStatus.CREATED);
        }
    }
}
