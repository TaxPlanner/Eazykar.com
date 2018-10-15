package com.project.web.easykar.model.registration;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationResult implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("usertype")
    @Expose
    private String usertype;
    @SerializedName("createdon")
    @Expose
    private String createdon;
    @SerializedName("ipaddress")
    @Expose
    private String ipaddress;
    @SerializedName("operatingsyatem")
    @Expose
    private String operatingsyatem;
    @SerializedName("status")
    @Expose
    private String status;
    private final static long serialVersionUID = 1408554443095335162L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getOperatingsyatem() {
        return operatingsyatem;
    }

    public void setOperatingsyatem(String operatingsyatem) {
        this.operatingsyatem = operatingsyatem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
