/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.easykar.profilecontroller;

import ch.qos.logback.core.CoreConstants;
import com.google.gson.Gson;
import com.project.web.easykar.constant.VariableConstant;
import com.project.web.easykar.global.Utility;
import com.project.web.easykar.model.profile.GetProfileByID;
import com.project.web.easykar.model.profile.GetProfileResponse;
import com.project.web.easykar.model.profile.ProfileResponse;
import com.project.web.easykar.model.profile.UserProfile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/profile"})
public class ProfileController {

    VariableConstant valConstant = new VariableConstant();
    private String BASEURL = valConstant.BaseUrl;
    private String URLPROFILE = valConstant.ApiProfile;
    private String URLGETPROFILE = valConstant.ApiGetProfile;
    private String message = "Manoj";
    private GetProfileResponse response2,response3;
    private static String UPLOADED_FOLDER = "//home//manoj//upload//";
    @Autowired
    private Utility utility;

    @GetMapping("/edit")
    public String setEdit() {
        return "userdashboard";
    }

    @RequestMapping(value = "/create_update", method = RequestMethod.POST)
    public String createUpdateProfile(WebRequest request, Model model, UserProfile userProf) {
        String ret = "redirect:/userdashboard";
        utility.setIsProfile(true);
        utility.setIsFiles(false);
        utility.setIsPlan(false);
        if (utility.getResGetProfileResponse() == null) {
            ret = createProfile(request, model, userProf);
            return ret;
        } else if (utility.getResGetProfileResponse() != null) {
            ret = updateProfile(request, model, userProf);
            return ret;
        } else {
            return "redirect:/userdashboard";
        }
    }

    public String createProfile(WebRequest request, Model model, UserProfile userProf) {
        Integer userID = null;
        if (utility.getIsLoin()) {
            userID = utility.getResLogin().getLoginResult().getId();
        }
        if (utility.getIsRegister()) {
            userID = utility.getResRegistration().getRegistrationResult().getId();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        JSONObject jsonCreate = new JSONObject();
        try {

            jsonCreate.put("userid", userID);
            jsonCreate.put("first_name", userProf.getFirst_name());
            jsonCreate.put("middle_name", userProf.getMiddle_name());
            jsonCreate.put("last_name", userProf.getLast_name());
            jsonCreate.put("mobile", userProf.getMobile());
            jsonCreate.put("dob", "2018-11-18");
            jsonCreate.put("pan_number", userProf.getPan_number());
            jsonCreate.put("address", userProf.getAddress());
            jsonCreate.put("createdon", "2018-11-18");
            jsonCreate.put("status", "1");

        } catch (JSONException ex) {
        }
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonCreate.toString(), httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        try {
            String res = restTemplate.postForObject(BASEURL + URLPROFILE, httpEntity, String.class);
            Gson gson = new Gson();
            ProfileResponse response = gson.fromJson(res.toString(), ProfileResponse.class);
            if (response.getResponseCode().equalsIgnoreCase("1")) {
                HttpHeaders httpHeaders3 = new HttpHeaders();
                httpHeaders3.set("Content-Type", "application/json");
                JSONObject jsonCreate3 = new JSONObject();
                jsonCreate3.put("userID", utility.getResRegistration().getRegistrationResult().getId());
                System.out.println("JSON >>>>>>" + jsonCreate3.toString());
                HttpEntity<String> httpEntity3 = new HttpEntity<String>(jsonCreate3.toString(), httpHeaders3);
                RestTemplate restTemplate3 = new RestTemplate();
                String res3 = restTemplate3.postForObject(BASEURL + URLGETPROFILE, httpEntity3, String.class);
                Gson gson3 = new Gson();
                response2 = gson3.fromJson(res3.toString(), GetProfileResponse.class);
                utility.setResGetProfileResponse(response2);
                if (response2.getResponseCode().equalsIgnoreCase("1")) {
                    utility.setMsgProfileSuccess("Profile has been saved successfully.");
                    model.addAttribute("firstName", response2.getProfileResult().getFirstName());
                    model.addAttribute("middleName", response2.getProfileResult().getMiddleName());
                    model.addAttribute("lastName", response2.getProfileResult().getLastName());
                    model.addAttribute("mobileNo", response2.getProfileResult().getMobile());
                    model.addAttribute("DOB", response2.getProfileResult().getDob());
                    model.addAttribute("panNo", response2.getProfileResult().getPanNumber());
                    model.addAttribute("address", response2.getProfileResult().getAddress());
                }else{
                    utility.setMsgProfileSuccess("Failed to save.");
                }
                return "redirect:/userdashboard";
            } else {
                return "redirect:/userdashboard";
            }
        } catch (Exception e) {
            return "redirect:/userdashboard";
        }
    }

    public String updateProfile(WebRequest request, Model model, UserProfile userProf) {
        Integer ID = 0, userID = 0;

        if (utility.getResGetProfileResponse() != null) {
            if (utility.getResGetProfileResponse().getResponseCode().equalsIgnoreCase("1")) {
                ID = utility.getResGetProfileResponse().getProfileResult().getId();
                userID = utility.getResGetProfileResponse().getProfileResult().getUserid();
            }
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        JSONObject jsonUpdate = new JSONObject();
        try {
            jsonUpdate.put("id", ID);
            jsonUpdate.put("userid", userID);
            jsonUpdate.put("first_name", userProf.getFirst_name());
            jsonUpdate.put("middle_name", userProf.getMiddle_name());
            jsonUpdate.put("last_name", userProf.getLast_name());
            jsonUpdate.put("mobile", userProf.getMobile());
            jsonUpdate.put("dob", "2018-11-14");
            jsonUpdate.put("pan_number", userProf.getPan_number());
            jsonUpdate.put("address", userProf.getAddress());
            jsonUpdate.put("createdon", "2018-11-28");
            jsonUpdate.put("status", "1");

        } catch (JSONException ex) {
        
        }
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonUpdate.toString(), httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        try {
            String res = restTemplate.postForObject(BASEURL + URLPROFILE, httpEntity, String.class);
            Gson gson = new Gson();
            ProfileResponse response = gson.fromJson(res.toString(), ProfileResponse.class);
            if (response.getResponseCode().equalsIgnoreCase("1")) {
                HttpHeaders httpHeaders2 = new HttpHeaders();
                httpHeaders2.set("Content-Type", "application/json");
                JSONObject jsonCreate = new JSONObject();
                jsonCreate.put("userID", utility.getResGetProfileResponse().getProfileResult().getUserid());
                
                HttpEntity<String> httpEntity2 = new HttpEntity<String>(jsonCreate.toString(), httpHeaders2);
                RestTemplate restTemplate2 = new RestTemplate();
                String res2 = restTemplate2.postForObject(BASEURL + URLGETPROFILE, httpEntity2, String.class);
                Gson gson2 = new Gson();
                response2 = gson2.fromJson(res2.toString(), GetProfileResponse.class);
                System.out.println("RES  >>>>>>" + response2.getProfileResult().getFirstName());
                if (response2.getResponseCode().equalsIgnoreCase("1")) {
                    utility.setMsgProfileSuccess("Profile has been updated successfully.");
                    
                    model.addAttribute("firstName", response2.getProfileResult().getFirstName());
                    model.addAttribute("middleName", response2.getProfileResult().getMiddleName());
                    model.addAttribute("lastName", response2.getProfileResult().getLastName());
                    model.addAttribute("mobileNo", response2.getProfileResult().getMobile());
                    model.addAttribute("DOB", response2.getProfileResult().getDob());
                    model.addAttribute("panNo", response2.getProfileResult().getPanNumber());
                    model.addAttribute("address", response2.getProfileResult().getAddress());
                }
                else{
                    utility.setMsgProfileSuccess("Failed to update.");
                }
                return "redirect:/userdashboard";
            } else {
                return "redirect:/userdashboard";
            }
        } catch (Exception e) {
            return "redirect:/userdashboard";
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadMultipleFiles(@RequestParam("docname") String[] docname, @RequestParam("password") String[] password, @RequestParam("description") String[] descriptions, @RequestParam("file") MultipartFile[] files) {
        utility.setIsProfile(false);
        utility.setIsFiles(true);
        utility.setIsPlan(false);
        String status = "",form16="",form26AS="";
        File dir = new File(UPLOADED_FOLDER);
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            try {
                byte[] bytes = file.getBytes();

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File uploadFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(uploadFile));
                outputStream.write(bytes);
                outputStream.close();

                if(i==0){
                    form16 = file.getOriginalFilename();
                }else{
                    form26AS = file.getOriginalFilename();
                }

            } catch (Exception e) {
            
            }

        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        JSONObject jsonCreate = new JSONObject();
        jsonCreate.put("userID", utility.getResGetProfileResponse().getProfileResult().getUserid());
        jsonCreate.put("form16", UPLOADED_FOLDER+form16);
        jsonCreate.put("form26AS", UPLOADED_FOLDER+form26AS);
        jsonCreate.put("otherDoc", "NA");
        jsonCreate.put("assessmentYear", "2018-2019");
        jsonCreate.put("status", 1);

        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonCreate.toString(), httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.postForObject(BASEURL + "/file/savefile", httpEntity, String.class);
        Gson gson = new Gson();
        response2 = gson.fromJson(res.toString(), GetProfileResponse.class);
        if(response2.getResponseCode().equalsIgnoreCase("1")){
            for(int i=0;i < docname.length;i++){
                HttpHeaders httpHeaders2 = new HttpHeaders();
                httpHeaders2.set("Content-Type", "application/json");
                JSONObject jsonCreate2 = new JSONObject();
                jsonCreate2.put("userID", utility.getResGetProfileResponse().getProfileResult().getUserid());
                jsonCreate2.put("documentName", docname[i].toString());
                jsonCreate2.put("password", password[i].toString());
                jsonCreate2.put("description", descriptions[i].toString());
                jsonCreate2.put("assessmentYear", "2018-2019");
                jsonCreate2.put("status", 1);
                HttpEntity<String> httpEntity2 = new HttpEntity<String>(jsonCreate2.toString(), httpHeaders2);
                RestTemplate restTemplate2 = new RestTemplate();
                String res2 = restTemplate2.postForObject(BASEURL + "/file/savedocs", httpEntity2, String.class);
                Gson gson2 = new Gson();
                response3 = gson2.fromJson(res2.toString(), GetProfileResponse.class);
                utility.setMsgDocumentSuccess("Document has been saved successfully.");
            }
            
        }else{
            utility.setMsgDocumentSuccess("Failed to upload.");
        }
        return "redirect:/userdashboard";
    }

}

//try {
//                byte[] bytes = file.getBytes();
//
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//
//                File uploadFile = new File(dir.getAbsolutePath()
//                        + File.separator + file.getOriginalFilename());
//                BufferedOutputStream outputStream = new BufferedOutputStream(
//                        new FileOutputStream(uploadFile));
//                outputStream.write(bytes);
//                outputStream.close();
//
//                status = status + "You successfully uploaded file=" + file.getOriginalFilename();
//                System.out.println(status);
//            } catch (Exception e) {
//                status = status + "Failed to upload " + file.getOriginalFilename() + " " + e.getMessage();
//            }
