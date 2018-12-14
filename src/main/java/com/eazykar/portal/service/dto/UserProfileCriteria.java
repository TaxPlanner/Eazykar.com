package com.eazykar.portal.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the UserProfile entity. This class is used in UserProfileResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /user-profiles?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class UserProfileCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter middleName;

    private StringFilter fathersName;

    private StringFilter mobileNumber;

    private StringFilter panNumber;

    private StringFilter addressLine1;

    private StringFilter addressLine2;

    private StringFilter addressLine3;

    private StringFilter addressLine4;

    private StringFilter city;

    private StringFilter state;

    private StringFilter pinCode;

    private LongFilter userId;

    public UserProfileCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getMiddleName() {
        return middleName;
    }

    public void setMiddleName(StringFilter middleName) {
        this.middleName = middleName;
    }

    public StringFilter getFathersName() {
        return fathersName;
    }

    public void setFathersName(StringFilter fathersName) {
        this.fathersName = fathersName;
    }

    public StringFilter getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(StringFilter mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public StringFilter getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(StringFilter panNumber) {
        this.panNumber = panNumber;
    }

    public StringFilter getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(StringFilter addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public StringFilter getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(StringFilter addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public StringFilter getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(StringFilter addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public StringFilter getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(StringFilter addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public StringFilter getCity() {
        return city;
    }

    public void setCity(StringFilter city) {
        this.city = city;
    }

    public StringFilter getState() {
        return state;
    }

    public void setState(StringFilter state) {
        this.state = state;
    }

    public StringFilter getPinCode() {
        return pinCode;
    }

    public void setPinCode(StringFilter pinCode) {
        this.pinCode = pinCode;
    }

    public LongFilter getUserId() {
        return userId;
    }

    public void setUserId(LongFilter userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserProfileCriteria that = (UserProfileCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(fathersName, that.fathersName) &&
            Objects.equals(mobileNumber, that.mobileNumber) &&
            Objects.equals(panNumber, that.panNumber) &&
            Objects.equals(addressLine1, that.addressLine1) &&
            Objects.equals(addressLine2, that.addressLine2) &&
            Objects.equals(addressLine3, that.addressLine3) &&
            Objects.equals(addressLine4, that.addressLine4) &&
            Objects.equals(city, that.city) &&
            Objects.equals(state, that.state) &&
            Objects.equals(pinCode, that.pinCode) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        middleName,
        fathersName,
        mobileNumber,
        panNumber,
        addressLine1,
        addressLine2,
        addressLine3,
        addressLine4,
        city,
        state,
        pinCode,
        userId
        );
    }

    @Override
    public String toString() {
        return "UserProfileCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (middleName != null ? "middleName=" + middleName + ", " : "") +
                (fathersName != null ? "fathersName=" + fathersName + ", " : "") +
                (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
                (panNumber != null ? "panNumber=" + panNumber + ", " : "") +
                (addressLine1 != null ? "addressLine1=" + addressLine1 + ", " : "") +
                (addressLine2 != null ? "addressLine2=" + addressLine2 + ", " : "") +
                (addressLine3 != null ? "addressLine3=" + addressLine3 + ", " : "") +
                (addressLine4 != null ? "addressLine4=" + addressLine4 + ", " : "") +
                (city != null ? "city=" + city + ", " : "") +
                (state != null ? "state=" + state + ", " : "") +
                (pinCode != null ? "pinCode=" + pinCode + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
