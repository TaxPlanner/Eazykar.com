package com.eazykar.portal.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @Size(max = 500)
    @Column(name = "employer_address", length = 500, nullable = false)
    private String employerAddress;

    @Column(name = "basic_pay", precision = 10, scale = 2)
    private BigDecimal basicPay;

    @Column(name = "hra", precision = 10, scale = 2)
    private BigDecimal hra;

    @Column(name = "conveyance", precision = 10, scale = 2)
    private BigDecimal conveyance;

    @Column(name = "medical", precision = 10, scale = 2)
    private BigDecimal medical;

    @Column(name = "lta", precision = 10, scale = 2)
    private BigDecimal lta;

    @Column(name = "others", precision = 10, scale = 2)
    private BigDecimal others;

    @Column(name = "perquisites", precision = 10, scale = 2)
    private BigDecimal perquisites;

    @Column(name = "leave_encashment", precision = 10, scale = 2)
    private BigDecimal leaveEncashment;

    @Column(name = "gratuity", precision = 10, scale = 2)
    private BigDecimal gratuity;

    @Column(name = "arrears", precision = 10, scale = 2)
    private BigDecimal arrears;

    @Column(name = "professional_tax", precision = 10, scale = 2)
    private BigDecimal professionalTax;

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

    public String getEmployerAddress() {
        return employerAddress;
    }

    public SalaryInformation employerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
        return this;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public BigDecimal getBasicPay() {
        return basicPay;
    }

    public SalaryInformation basicPay(BigDecimal basicPay) {
        this.basicPay = basicPay;
        return this;
    }

    public void setBasicPay(BigDecimal basicPay) {
        this.basicPay = basicPay;
    }

    public BigDecimal getHra() {
        return hra;
    }

    public SalaryInformation hra(BigDecimal hra) {
        this.hra = hra;
        return this;
    }

    public void setHra(BigDecimal hra) {
        this.hra = hra;
    }

    public BigDecimal getConveyance() {
        return conveyance;
    }

    public SalaryInformation conveyance(BigDecimal conveyance) {
        this.conveyance = conveyance;
        return this;
    }

    public void setConveyance(BigDecimal conveyance) {
        this.conveyance = conveyance;
    }

    public BigDecimal getMedical() {
        return medical;
    }

    public SalaryInformation medical(BigDecimal medical) {
        this.medical = medical;
        return this;
    }

    public void setMedical(BigDecimal medical) {
        this.medical = medical;
    }

    public BigDecimal getLta() {
        return lta;
    }

    public SalaryInformation lta(BigDecimal lta) {
        this.lta = lta;
        return this;
    }

    public void setLta(BigDecimal lta) {
        this.lta = lta;
    }

    public BigDecimal getOthers() {
        return others;
    }

    public SalaryInformation others(BigDecimal others) {
        this.others = others;
        return this;
    }

    public void setOthers(BigDecimal others) {
        this.others = others;
    }

    public BigDecimal getPerquisites() {
        return perquisites;
    }

    public SalaryInformation perquisites(BigDecimal perquisites) {
        this.perquisites = perquisites;
        return this;
    }

    public void setPerquisites(BigDecimal perquisites) {
        this.perquisites = perquisites;
    }

    public BigDecimal getLeaveEncashment() {
        return leaveEncashment;
    }

    public SalaryInformation leaveEncashment(BigDecimal leaveEncashment) {
        this.leaveEncashment = leaveEncashment;
        return this;
    }

    public void setLeaveEncashment(BigDecimal leaveEncashment) {
        this.leaveEncashment = leaveEncashment;
    }

    public BigDecimal getGratuity() {
        return gratuity;
    }

    public SalaryInformation gratuity(BigDecimal gratuity) {
        this.gratuity = gratuity;
        return this;
    }

    public void setGratuity(BigDecimal gratuity) {
        this.gratuity = gratuity;
    }

    public BigDecimal getArrears() {
        return arrears;
    }

    public SalaryInformation arrears(BigDecimal arrears) {
        this.arrears = arrears;
        return this;
    }

    public void setArrears(BigDecimal arrears) {
        this.arrears = arrears;
    }

    public BigDecimal getProfessionalTax() {
        return professionalTax;
    }

    public SalaryInformation professionalTax(BigDecimal professionalTax) {
        this.professionalTax = professionalTax;
        return this;
    }

    public void setProfessionalTax(BigDecimal professionalTax) {
        this.professionalTax = professionalTax;
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
            ", employerAddress='" + getEmployerAddress() + "'" +
            ", basicPay=" + getBasicPay() +
            ", hra=" + getHra() +
            ", conveyance=" + getConveyance() +
            ", medical=" + getMedical() +
            ", lta=" + getLta() +
            ", others=" + getOthers() +
            ", perquisites=" + getPerquisites() +
            ", leaveEncashment=" + getLeaveEncashment() +
            ", gratuity=" + getGratuity() +
            ", arrears=" + getArrears() +
            ", professionalTax=" + getProfessionalTax() +
            "}";
    }
}
