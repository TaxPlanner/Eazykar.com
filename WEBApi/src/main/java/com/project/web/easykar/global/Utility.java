package com.project.web.easykar.global;

import com.project.web.easykar.model.login.LoginResponse;
import com.project.web.easykar.model.profile.GetProfileResponse;
import com.project.web.easykar.model.registration.RegistrationResponse;
import java.io.Serializable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class Utility {
    public LoginResponse resLogin = null;
    public RegistrationResponse resRegistration = null;
    public GetProfileResponse resGetProfileResponse = null;
    public boolean IsLoin=false, IsRegister = false, IsEditProfile = false;
    public String name,MsgProfileSuccess="",MsgDocumentSuccess="";
    public boolean IsProfile=false,IsFiles=false,IsPlan=false;
    public String msgLoginError="",msgRegistrationError="";
    public boolean IsLoginActive=false,IsRegistrationActive=false;

    public boolean getIsLoginActive() {
        return IsLoginActive;
    }

    public void setIsLoginActive(boolean IsLoginActive) {
        this.IsLoginActive = IsLoginActive;
    }

    public boolean getIsRegistrationActive() {
        return IsRegistrationActive;
    }

    public void setIsRegistrationActive(boolean IsRegistrationActive) {
        this.IsRegistrationActive = IsRegistrationActive;
    }
    
    
    public String getMsgLoginError() {
        return msgLoginError;
    }

    public void setMsgLoginError(String msgLoginError) {
        this.msgLoginError = msgLoginError;
    }

    public String getMsgRegistrationError() {
        return msgRegistrationError;
    }

    public void setMsgRegistrationError(String msgRegistrationError) {
        this.msgRegistrationError = msgRegistrationError;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsgDocumentSuccess() {
        return MsgDocumentSuccess;
    }

    public void setMsgDocumentSuccess(String MsgDocumentSuccess) {
        this.MsgDocumentSuccess = MsgDocumentSuccess;
    }

    public String getMsgProfileSuccess() {
        return MsgProfileSuccess;
    }

    public void setMsgProfileSuccess(String MsgProfileSuccess) {
        this.MsgProfileSuccess = MsgProfileSuccess;
    }

    public boolean getIsProfile() {
        return IsProfile;
    }

    public void setIsProfile(boolean IsProfile) {
        this.IsProfile = IsProfile;
    }

    public boolean getIsFiles() {
        return IsFiles;
    }

    public void setIsFiles(boolean IsFiles) {
        this.IsFiles = IsFiles;
    }

    public boolean getIsPlan() {
        return IsPlan;
    }

    public void setIsPlan(boolean IsPlan) {
        this.IsPlan = IsPlan;
    }
    
    
    public LoginResponse getResLogin() {
        return resLogin;
    }

    public void setResLogin(LoginResponse resLogin) {
        this.resLogin = resLogin;
    }

    public RegistrationResponse getResRegistration() {
        return resRegistration;
    }

    public void setResRegistration(RegistrationResponse resRegistration) {
        this.resRegistration = resRegistration;
    }

    public boolean getIsLoin() {
        return IsLoin;
    }

    public void setIsLoin(boolean IsLoin) {
        this.IsLoin = IsLoin;
    }

    public boolean getIsRegister() {
        return IsRegister;
    }

    public void setIsRegister(boolean IsRegister) {
        this.IsRegister = IsRegister;
    }

    public boolean getIsEditProfile() {
        return IsEditProfile;
    }

    public void setIsEditProfile(boolean IsEditProfile) {
        this.IsEditProfile = IsEditProfile;
    }

    public GetProfileResponse getResGetProfileResponse() {
        return resGetProfileResponse;
    }

    public void setResGetProfileResponse(GetProfileResponse resGetProfileResponse) {
        this.resGetProfileResponse = resGetProfileResponse;
    }
    
}
