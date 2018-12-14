package com.eazykar.portal.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.eazykar.portal.domain.enumeration.ItrApplicationStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A ItrApplication.
 */
@Entity
@Table(name = "itr_application")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ItrApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "application_number", length = 20, nullable = false)
    private String applicationNumber;

    @Size(min = 9, max = 9)
    @Pattern(regexp = "\\d{4}-\\d{4}")
    @Column(name = "assessment_year", length = 9)
    private String assessmentYear;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "application_status", nullable = false)
    private ItrApplicationStatus applicationStatus;

    @OneToOne(optional = false)    @NotNull
    @JoinColumn(unique = true)
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("")
    private User assignee;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public ItrApplication applicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getAssessmentYear() {
        return assessmentYear;
    }

    public ItrApplication assessmentYear(String assessmentYear) {
        this.assessmentYear = assessmentYear;
        return this;
    }

    public void setAssessmentYear(String assessmentYear) {
        this.assessmentYear = assessmentYear;
    }

    public ItrApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public ItrApplication applicationStatus(ItrApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
        return this;
    }

    public void setApplicationStatus(ItrApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public User getUser() {
        return user;
    }

    public ItrApplication user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAssignee() {
        return assignee;
    }

    public ItrApplication assignee(User user) {
        this.assignee = user;
        return this;
    }

    public void setAssignee(User user) {
        this.assignee = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItrApplication itrApplication = (ItrApplication) o;
        if (itrApplication.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), itrApplication.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ItrApplication{" +
            "id=" + getId() +
            ", applicationNumber='" + getApplicationNumber() + "'" +
            ", assessmentYear='" + getAssessmentYear() + "'" +
            ", applicationStatus='" + getApplicationStatus() + "'" +
            "}";
    }
}
