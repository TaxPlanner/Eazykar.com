package com.eazykar.portal.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A UserProfile.
 */
@Entity
@Table(name = "user_profile")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Size(max = 200)
    @Column(name = "fathers_name", length = 200)
    private String fathersName;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "\\d{10}")
    @Column(name = "mobile_number", length = 10, nullable = false, unique = true)
    private String mobileNumber;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[A-Za-z]{5}\\d{4}[A-Za-z]{1}")
    @Column(name = "pan_number", length = 10, nullable = false, unique = true)
    private String panNumber;

    @Size(max = 200)
    @Column(name = "address_line_1", length = 200)
    private String addressLine1;

    @Size(max = 200)
    @Column(name = "address_line_2", length = 200)
    private String addressLine2;

    @Size(max = 200)
    @Column(name = "address_line_3", length = 200)
    private String addressLine3;

    @Size(max = 200)
    @Column(name = "address_line_4", length = 200)
    private String addressLine4;

    @Size(max = 200)
    @Column(name = "city", length = 200)
    private String city;

    @Size(max = 200)
    @Column(name = "state", length = 200)
    private String state;

    @Size(min = 6, max = 6)
    @Pattern(regexp = "\\d{6}")
    @Column(name = "pin_code", length = 6)
    private String pinCode;

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

    public String getMiddleName() {
        return middleName;
    }

    public UserProfile middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public UserProfile fathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public UserProfile mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public UserProfile panNumber(String panNumber) {
        this.panNumber = panNumber;
        return this;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public UserProfile addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public UserProfile addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public UserProfile addressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public UserProfile addressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
        return this;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getCity() {
        return city;
    }

    public UserProfile city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public UserProfile state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public UserProfile pinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public User getUser() {
        return user;
    }

    public UserProfile user(User user) {
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
        UserProfile userProfile = (UserProfile) o;
        if (userProfile.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userProfile.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserProfile{" +
            "id=" + getId() +
            ", middleName='" + getMiddleName() + "'" +
            ", fathersName='" + getFathersName() + "'" +
            ", mobileNumber='" + getMobileNumber() + "'" +
            ", panNumber='" + getPanNumber() + "'" +
            ", addressLine1='" + getAddressLine1() + "'" +
            ", addressLine2='" + getAddressLine2() + "'" +
            ", addressLine3='" + getAddressLine3() + "'" +
            ", addressLine4='" + getAddressLine4() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            "}";
    }
}
