package com.eazykar.portal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A Deduction.
 */
@Entity
@Table(name = "deduction")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Deduction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "d_80_c", precision = 10, scale = 2)
    private BigDecimal d80C;

    @Column(name = "d_80_tta", precision = 10, scale = 2)
    private BigDecimal d80TTA;

    @Column(name = "d_80_g", precision = 10, scale = 2)
    private BigDecimal d80G;

    @Column(name = "d_80_d_preventive_health", precision = 10, scale = 2)
    private BigDecimal d80DPreventiveHealth;

    @Column(name = "d_80_d_insurance_family_premium", precision = 10, scale = 2)
    private BigDecimal d80DInsuranceFamilyPremium;

    @Column(name = "d_80_d_family_check_up_fees", precision = 10, scale = 2)
    private BigDecimal d80DFamilyCheckUpFees;

    @Column(name = "d_80_d_insurance_parents_premium", precision = 10, scale = 2)
    private BigDecimal d80DInsuranceParentsPremium;

    @Column(name = "d_80_d_parents_check_up_fees", precision = 10, scale = 2)
    private BigDecimal d80DParentsCheckUpFees;

    @Column(name = "d_80_d_parents_senior_citizens")
    private Boolean d80DParentsSeniorCitizens;

    @Column(name = "d_80_e", precision = 10, scale = 2)
    private BigDecimal d80E;

    @Column(name = "d_80_ccc", precision = 10, scale = 2)
    private BigDecimal d80CCC;

    @Column(name = "d_80_ccd_2", precision = 10, scale = 2)
    private BigDecimal d80CCD2;

    @Column(name = "other_deductions", precision = 10, scale = 2)
    private BigDecimal otherDeductions;

    @OneToOne(optional = false)    @NotNull
    @JoinColumn(unique = true)
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getd80C() {
        return d80C;
    }

    public Deduction d80C(BigDecimal d80C) {
        this.d80C = d80C;
        return this;
    }

    public void setd80C(BigDecimal d80C) {
        this.d80C = d80C;
    }

    public BigDecimal getd80TTA() {
        return d80TTA;
    }

    public Deduction d80TTA(BigDecimal d80TTA) {
        this.d80TTA = d80TTA;
        return this;
    }

    public void setd80TTA(BigDecimal d80TTA) {
        this.d80TTA = d80TTA;
    }

    public BigDecimal getd80G() {
        return d80G;
    }

    public Deduction d80G(BigDecimal d80G) {
        this.d80G = d80G;
        return this;
    }

    public void setd80G(BigDecimal d80G) {
        this.d80G = d80G;
    }

    public BigDecimal getd80DPreventiveHealth() {
        return d80DPreventiveHealth;
    }

    public Deduction d80DPreventiveHealth(BigDecimal d80DPreventiveHealth) {
        this.d80DPreventiveHealth = d80DPreventiveHealth;
        return this;
    }

    public void setd80DPreventiveHealth(BigDecimal d80DPreventiveHealth) {
        this.d80DPreventiveHealth = d80DPreventiveHealth;
    }

    public BigDecimal getd80DInsuranceFamilyPremium() {
        return d80DInsuranceFamilyPremium;
    }

    public Deduction d80DInsuranceFamilyPremium(BigDecimal d80DInsuranceFamilyPremium) {
        this.d80DInsuranceFamilyPremium = d80DInsuranceFamilyPremium;
        return this;
    }

    public void setd80DInsuranceFamilyPremium(BigDecimal d80DInsuranceFamilyPremium) {
        this.d80DInsuranceFamilyPremium = d80DInsuranceFamilyPremium;
    }

    public BigDecimal getd80DFamilyCheckUpFees() {
        return d80DFamilyCheckUpFees;
    }

    public Deduction d80DFamilyCheckUpFees(BigDecimal d80DFamilyCheckUpFees) {
        this.d80DFamilyCheckUpFees = d80DFamilyCheckUpFees;
        return this;
    }

    public void setd80DFamilyCheckUpFees(BigDecimal d80DFamilyCheckUpFees) {
        this.d80DFamilyCheckUpFees = d80DFamilyCheckUpFees;
    }

    public BigDecimal getd80DInsuranceParentsPremium() {
        return d80DInsuranceParentsPremium;
    }

    public Deduction d80DInsuranceParentsPremium(BigDecimal d80DInsuranceParentsPremium) {
        this.d80DInsuranceParentsPremium = d80DInsuranceParentsPremium;
        return this;
    }

    public void setd80DInsuranceParentsPremium(BigDecimal d80DInsuranceParentsPremium) {
        this.d80DInsuranceParentsPremium = d80DInsuranceParentsPremium;
    }

    public BigDecimal getd80DParentsCheckUpFees() {
        return d80DParentsCheckUpFees;
    }

    public Deduction d80DParentsCheckUpFees(BigDecimal d80DParentsCheckUpFees) {
        this.d80DParentsCheckUpFees = d80DParentsCheckUpFees;
        return this;
    }

    public void setd80DParentsCheckUpFees(BigDecimal d80DParentsCheckUpFees) {
        this.d80DParentsCheckUpFees = d80DParentsCheckUpFees;
    }

    public Boolean isd80DParentsSeniorCitizens() {
        return d80DParentsSeniorCitizens;
    }

    public Deduction d80DParentsSeniorCitizens(Boolean d80DParentsSeniorCitizens) {
        this.d80DParentsSeniorCitizens = d80DParentsSeniorCitizens;
        return this;
    }

    public void setd80DParentsSeniorCitizens(Boolean d80DParentsSeniorCitizens) {
        this.d80DParentsSeniorCitizens = d80DParentsSeniorCitizens;
    }

    public BigDecimal getd80E() {
        return d80E;
    }

    public Deduction d80E(BigDecimal d80E) {
        this.d80E = d80E;
        return this;
    }

    public void setd80E(BigDecimal d80E) {
        this.d80E = d80E;
    }

    public BigDecimal getd80CCC() {
        return d80CCC;
    }

    public Deduction d80CCC(BigDecimal d80CCC) {
        this.d80CCC = d80CCC;
        return this;
    }

    public void setd80CCC(BigDecimal d80CCC) {
        this.d80CCC = d80CCC;
    }

    public BigDecimal getd80CCD2() {
        return d80CCD2;
    }

    public Deduction d80CCD2(BigDecimal d80CCD2) {
        this.d80CCD2 = d80CCD2;
        return this;
    }

    public void setd80CCD2(BigDecimal d80CCD2) {
        this.d80CCD2 = d80CCD2;
    }

    public BigDecimal getOtherDeductions() {
        return otherDeductions;
    }

    public Deduction otherDeductions(BigDecimal otherDeductions) {
        this.otherDeductions = otherDeductions;
        return this;
    }

    public void setOtherDeductions(BigDecimal otherDeductions) {
        this.otherDeductions = otherDeductions;
    }

    public User getUser() {
        return user;
    }

    public Deduction user(User user) {
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
        Deduction deduction = (Deduction) o;
        if (deduction.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), deduction.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Deduction{" +
            "id=" + getId() +
            ", d80C=" + getd80C() +
            ", d80TTA=" + getd80TTA() +
            ", d80G=" + getd80G() +
            ", d80DPreventiveHealth=" + getd80DPreventiveHealth() +
            ", d80DInsuranceFamilyPremium=" + getd80DInsuranceFamilyPremium() +
            ", d80DFamilyCheckUpFees=" + getd80DFamilyCheckUpFees() +
            ", d80DInsuranceParentsPremium=" + getd80DInsuranceParentsPremium() +
            ", d80DParentsCheckUpFees=" + getd80DParentsCheckUpFees() +
            ", d80DParentsSeniorCitizens='" + isd80DParentsSeniorCitizens() + "'" +
            ", d80E=" + getd80E() +
            ", d80CCC=" + getd80CCC() +
            ", d80CCD2=" + getd80CCD2() +
            ", otherDeductions=" + getOtherDeductions() +
            "}";
    }
}
