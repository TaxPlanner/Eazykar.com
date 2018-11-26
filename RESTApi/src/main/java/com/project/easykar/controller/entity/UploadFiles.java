/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.controller.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Objects;
import javafx.scene.text.Text;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author manoj
 */
@Entity
@Table(name = "upload")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadFiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "userID", length = 50)
    Long userID;
    
    @Column(name = "form16", length = 50)
    @Type(type="text")
    String form16;
    
    @Column(name = "form26AS", length = 50)
    @Type(type="text")
    String form26AS;
     
    @Column(name = "otherDoc", length = 50)
    String otherDoc;
     
    @Column(name = "assessmentYear", length = 50)
    String assessmentYear;
    
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

    public String getForm16() {
        return form16;
    }

    public void setForm16(String form16) {
        this.form16 = form16;
    }

    public String getForm26AS() {
        return form26AS;
    }

    public void setForm26AS(String form26AS) {
        this.form26AS = form26AS;
    }

    public String getOtherDoc() {
        return otherDoc;
    }

    public void setOtherDoc(String otherDoc) {
        this.otherDoc = otherDoc;
    }

    public String getAssessmentYear() {
        return assessmentYear;
    }

    public void setAssessmentYear(String assessmentYear) {
        this.assessmentYear = assessmentYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.userID);
        hash = 37 * hash + Objects.hashCode(this.form16);
        hash = 37 * hash + Objects.hashCode(this.form26AS);
        hash = 37 * hash + Objects.hashCode(this.otherDoc);
        hash = 37 * hash + Objects.hashCode(this.assessmentYear);
        hash = 37 * hash + Objects.hashCode(this.status);
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
        final UploadFiles other = (UploadFiles) obj;
        if (!Objects.equals(this.form16, other.form16)) {
            return false;
        }
        if (!Objects.equals(this.form26AS, other.form26AS)) {
            return false;
        }
        if (!Objects.equals(this.otherDoc, other.otherDoc)) {
            return false;
        }
        if (!Objects.equals(this.assessmentYear, other.assessmentYear)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UploadFiles{" + "id=" + id + ", userID=" + userID + ", form16=" + form16 + ", form26AS=" + form26AS + ", otherDoc=" + otherDoc + ", assessmentYear=" + assessmentYear + ", status=" + status + '}';
    }

    
    
}
