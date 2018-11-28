package com.easykar.rest.controller.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "user_profile")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfile implements Serializable {
    
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "userid", length = 50)
    Long userid;
    
    @Column(name = "first_name", length = 50)
    String first_name;
    
    @Column(name = "middle_name", length = 50)
    String middle_name;
    
    @Column(name = "last_name", length = 50)
    String last_name;
    
    @Column(name = "mobile", length = 15)
    Long mobile;
    
    @Column(name = "dob", length = 50)
    String dob;
    
    @Column(name = "pan_number", length = 50)
    String pan_number;
    
    @Column(name = "address", length = 50)
    String address;
    
    @Column(name = "createdon", length = 50)
    String createdon;
    
    @Column(name = "status", length = 50)
    Integer status;
    
    public UserProfile() {
    }
    
    public UserProfile(Long id, Long userid, String first_name, String middle_name, String last_name, Long mobile, String dob, String pan_number,
            String address, String createdon, Integer status) {
        this.id = id;
        this.userid = userid;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.dob = dob;
        this.pan_number = pan_number;
        this.address = address;
        this.createdon = createdon;
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserid() {
        return userid;
    }
    
    public void setUserid(Long userid) {
        this.userid = userid;
    }
    
    public String getFirst_name() {
        return first_name;
    }
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public String getMiddle_name() {
        return middle_name;
    }
    
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }
    
    public String getLast_name() {
        return last_name;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public Long getMobile() {
        return mobile;
    }
    
    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }
    
    public String getDob() {
        return dob;
    }
    
    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public String getPan_number() {
        return pan_number;
    }
    
    public void setPan_number(String pan_number) {
        this.pan_number = pan_number;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCreatedon() {
        return createdon;
    }
    
    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    //    @Override
    //    public int hashCode() {
    //        int hash = 0;
    //        hash += (id != null ? id.hashCode() : 0);
    //        return hash;
    //    }
    //
    //    @Override
    //    public boolean equals(Object object) {
    //        // TODO: Warning - this method won't work in the case the id fields are not set
    //        if (!(object instanceof UserProfile)) {
    //            return false;
    //        }
    //        UserProfile other = (UserProfile) object;
    //        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
    //            return false;
    //        }
    //        return true;
    //    }
    //
    //    @Override
    //    public String toString() {
    //        return "UserProfile[ id=" + id + " ]";
    //    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.userid);
        hash = 31 * hash + Objects.hashCode(this.first_name);
        hash = 31 * hash + Objects.hashCode(this.middle_name);
        hash = 31 * hash + Objects.hashCode(this.last_name);
        hash = 31 * hash + Objects.hashCode(this.mobile);
        hash = 31 * hash + Objects.hashCode(this.dob);
        hash = 31 * hash + Objects.hashCode(this.pan_number);
        hash = 31 * hash + Objects.hashCode(this.address);
        hash = 31 * hash + Objects.hashCode(this.createdon);
        hash = 31 * hash + Objects.hashCode(this.status);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserProfile other = (UserProfile) obj;
        if (!Objects.equals(this.userid, other.userid)) {
            return false;
        }
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.middle_name, other.middle_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.pan_number, other.pan_number)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.createdon, other.createdon)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.mobile, other.mobile)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }
    
    @Override
    public String toString() {
        return "UserProfile{" + "id=" + id + ", user_ID=" + userid + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
                + last_name + ", mobile=" + mobile + ", dob=" + dob + ", pan_number=" + pan_number + ", address=" + address + ", createdon="
                + createdon + ", status=" + status + '}';
    }
    
}
