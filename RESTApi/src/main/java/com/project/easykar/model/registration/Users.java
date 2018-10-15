/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.model.registration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author manoj
 */

@Entity
@Table(name = "users")
@JsonInclude(Include.NON_NULL)
public class Users implements java.io.Serializable{
    
    private static final long serialVersionUID = 4910225916550731446L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    long id;
    @Column(name = "email", length = 50)
    String email;
    @Column(name = "password", length = 50)
    String password;
    @Column(name = "usertype", length = 50)
    String usertype;
    @Column(name = "createdon", length = 50)
    String createdon;
    @Column(name = "ipaddress", length = 50)
    String ipaddress;
    @Column(name = "operatingsyatem", length = 50)
    String operatingsyatem;
    @Column(name = "status", length = 50)
    String status;
    
    
    public Users() {
    }
    
    public Users(long id) {
        this.id = id;
    }

    public Users(long id, String email, String password, String usertype, String createdon, String ipaddress, String operatingsyatem, String status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.createdon = createdon;
        this.ipaddress = ipaddress;
        this.operatingsyatem = operatingsyatem;
        this.status = status;
    }

    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.usertype);
        hash = 97 * hash + Objects.hashCode(this.createdon);
        hash = 97 * hash + Objects.hashCode(this.ipaddress);
        hash = 97 * hash + Objects.hashCode(this.operatingsyatem);
        hash = 97 * hash + Objects.hashCode(this.status);
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
        final Users other = (Users) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.usertype, other.usertype)) {
            return false;
        }
        if (!Objects.equals(this.createdon, other.createdon)) {
            return false;
        }
        if (!Objects.equals(this.ipaddress, other.ipaddress)) {
            return false;
        }
        if (!Objects.equals(this.operatingsyatem, other.operatingsyatem)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", email=" + email + ", password=" + password + ", usertype=" + usertype + ", createdon=" + createdon + ", ipaddress=" + ipaddress + ", operatingsyatem=" + operatingsyatem + ", status=" + status + '}';
      //  return "{\"id\":1,\"email\":2,\"password\":3,\"usertype\":4,\"ipaddress\":5,\"operatingsyatem\":6,\"createdon\":7,\"status\":8}";
    }

}
