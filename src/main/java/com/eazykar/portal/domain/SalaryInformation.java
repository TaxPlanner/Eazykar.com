package com.eazykar.portal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.eazykar.portal.domain.enumeration.EmployerType;

/**
 * A SalaryInformation.
 */
@Entity
@Table(name = "salary_information")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SalaryInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(name = "employer_name", length = 200, nullable = false)
    private String employerName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "employer_type", nullable = false)
    private EmployerType employerType;

    @NotNull
    @Size(max = 10)
    @Column(name = "employer_tan", length = 10, nullable = false)
    private String employerTan;

    @NotNull
    @Column(name = "income", precision = 10, scale = 2, nullable = false)
    private BigDecimal income;

    @NotNull
    @Column(name = "tds", precision = 10, scale = 2, nullable = false)
    private BigDecimal tds;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("")
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployerName() {
        return employerName;
    }

    public SalaryInformation employerName(String employerName) {
        this.employerName = employerName;
        return this;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public EmployerType getEmployerType() {
        return employerType;
    }

    public SalaryInformation employerType(EmployerType employerType) {
        this.employerType = employerType;
        return this;
    }

    public void setEmployerType(EmployerType employerType) {
        this.employerType = employerType;
    }

    public String getEmployerTan() {
        return employerTan;
    }

    public SalaryInformation employerTan(String employerTan) {
        this.employerTan = employerTan;
        return this;
    }

    public void setEmployerTan(String employerTan) {
        this.employerTan = employerTan;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public SalaryInformation income(BigDecimal income) {
        this.income = income;
        return this;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getTds() {
        return tds;
    }

    public SalaryInformation tds(BigDecimal tds) {
        this.tds = tds;
        return this;
    }

    public void setTds(BigDecimal tds) {
        this.tds = tds;
    }

    public User getUser() {
        return user;
    }

    public SalaryInformation user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
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
        SalaryInformation salaryInformation = (SalaryInformation) o;
        if (salaryInformation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), salaryInformation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SalaryInformation{" +
            "id=" + getId() +
            ", employerName='" + getEmployerName() + "'" +
            ", employerType='" + getEmployerType() + "'" +
            ", employerTan='" + getEmployerTan() + "'" +
            ", income=" + getIncome() +
            ", tds=" + getTds() +
            "}";
    }
}
