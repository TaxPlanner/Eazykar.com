package com.eazykar.portal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A OtherIncome.
 */
@Entity
@Table(name = "other_income")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class OtherIncome implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "interest_income", precision = 10, scale = 2)
    private BigDecimal interestIncome;

    @Column(name = "any_other_income", precision = 10, scale = 2)
    private BigDecimal anyOtherIncome;

    @Column(name = "exempt_dividend", precision = 10, scale = 2)
    private BigDecimal exemptDividend;

    @Column(name = "exempt_interest", precision = 10, scale = 2)
    private BigDecimal exemptInterest;

    @Column(name = "exempt_other_income", precision = 10, scale = 2)
    private BigDecimal exemptOtherIncome;

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

    public BigDecimal getInterestIncome() {
        return interestIncome;
    }

    public OtherIncome interestIncome(BigDecimal interestIncome) {
        this.interestIncome = interestIncome;
        return this;
    }

    public void setInterestIncome(BigDecimal interestIncome) {
        this.interestIncome = interestIncome;
    }

    public BigDecimal getAnyOtherIncome() {
        return anyOtherIncome;
    }

    public OtherIncome anyOtherIncome(BigDecimal anyOtherIncome) {
        this.anyOtherIncome = anyOtherIncome;
        return this;
    }

    public void setAnyOtherIncome(BigDecimal anyOtherIncome) {
        this.anyOtherIncome = anyOtherIncome;
    }

    public BigDecimal getExemptDividend() {
        return exemptDividend;
    }

    public OtherIncome exemptDividend(BigDecimal exemptDividend) {
        this.exemptDividend = exemptDividend;
        return this;
    }

    public void setExemptDividend(BigDecimal exemptDividend) {
        this.exemptDividend = exemptDividend;
    }

    public BigDecimal getExemptInterest() {
        return exemptInterest;
    }

    public OtherIncome exemptInterest(BigDecimal exemptInterest) {
        this.exemptInterest = exemptInterest;
        return this;
    }

    public void setExemptInterest(BigDecimal exemptInterest) {
        this.exemptInterest = exemptInterest;
    }

    public BigDecimal getExemptOtherIncome() {
        return exemptOtherIncome;
    }

    public OtherIncome exemptOtherIncome(BigDecimal exemptOtherIncome) {
        this.exemptOtherIncome = exemptOtherIncome;
        return this;
    }

    public void setExemptOtherIncome(BigDecimal exemptOtherIncome) {
        this.exemptOtherIncome = exemptOtherIncome;
    }

    public User getUser() {
        return user;
    }

    public OtherIncome user(User user) {
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
        OtherIncome otherIncome = (OtherIncome) o;
        if (otherIncome.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), otherIncome.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OtherIncome{" +
            "id=" + getId() +
            ", interestIncome=" + getInterestIncome() +
            ", anyOtherIncome=" + getAnyOtherIncome() +
            ", exemptDividend=" + getExemptDividend() +
            ", exemptInterest=" + getExemptInterest() +
            ", exemptOtherIncome=" + getExemptOtherIncome() +
            "}";
    }
}
