package com.eazykar.portal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A HouseProperty.
 */
@Entity
@Table(name = "house_property")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class HouseProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 1000)
    @Column(name = "address", length = 1000)
    private String address;

    @Size(max = 200)
    @Column(name = "tenant", length = 200)
    private String tenant;

    @Column(name = "property_tax", precision = 10, scale = 2)
    private BigDecimal propertyTax;

    @Column(name = "housing_loan_interest", precision = 10, scale = 2)
    private BigDecimal housingLoanInterest;

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

    public String getAddress() {
        return address;
    }

    public HouseProperty address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTenant() {
        return tenant;
    }

    public HouseProperty tenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public BigDecimal getPropertyTax() {
        return propertyTax;
    }

    public HouseProperty propertyTax(BigDecimal propertyTax) {
        this.propertyTax = propertyTax;
        return this;
    }

    public void setPropertyTax(BigDecimal propertyTax) {
        this.propertyTax = propertyTax;
    }

    public BigDecimal getHousingLoanInterest() {
        return housingLoanInterest;
    }

    public HouseProperty housingLoanInterest(BigDecimal housingLoanInterest) {
        this.housingLoanInterest = housingLoanInterest;
        return this;
    }

    public void setHousingLoanInterest(BigDecimal housingLoanInterest) {
        this.housingLoanInterest = housingLoanInterest;
    }

    public User getUser() {
        return user;
    }

    public HouseProperty user(User user) {
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
        HouseProperty houseProperty = (HouseProperty) o;
        if (houseProperty.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), houseProperty.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HouseProperty{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", tenant='" + getTenant() + "'" +
            ", propertyTax=" + getPropertyTax() +
            ", housingLoanInterest=" + getHousingLoanInterest() +
            "}";
    }
}
