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
@Table(name = "documents")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Documents implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "userID", length = 50)
    Long userID;
    
    @Column(name = "assessmentYear", length = 50)
    String assessmentYear;
    
    @Column(name = "documentName", length = 50)
    String documentName;
    
    @Column(name = "password", length = 50)
    String password;
    
    @Column(name = "description", length = 50)
    String description;
    
    @Column(name = "status", length = 50)
    String status;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserID() {
        return userID;
    }
    
    public void setUserID(Long userID) {
        this.userID = userID;
    }
    
    public String getAssessmentYear() {
        return assessmentYear;
    }
    
    public void setAssessmentYear(String assessmentYear) {
        this.assessmentYear = assessmentYear;
    }
    
    public String getDocumentName() {
        return documentName;
    }
    
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.userID);
        hash = 13 * hash + Objects.hashCode(this.assessmentYear);
        hash = 13 * hash + Objects.hashCode(this.documentName);
        hash = 13 * hash + Objects.hashCode(this.password);
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + Objects.hashCode(this.status);
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
        final Documents other = (Documents) obj;
        if (!Objects.equals(this.assessmentYear, other.assessmentYear)) {
            return false;
        }
        if (!Objects.equals(this.documentName, other.documentName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.userID, other.userID);
    }
    
    @Override
    public String toString() {
        return "Documents{" + "id=" + id + ", userID=" + userID + ", assessmentYear=" + assessmentYear + ", documentName=" + documentName
                + ", password=" + password + ", description=" + description + ", status=" + status + '}';
    }
    
}
