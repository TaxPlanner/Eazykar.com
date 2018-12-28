package com.eazykar.portal.service.dto;

import java.io.Serializable;
import java.util.Objects;

import com.eazykar.portal.domain.enumeration.Gender;
import com.eazykar.portal.domain.enumeration.MaritalStatus;

import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LocalDateFilter;
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
    /**
     * Class for filtering Gender
     */
    public static class GenderFilter extends Filter<Gender> {
    }
    /**
     * Class for filtering MaritalStatus
     */
    public static class MaritalStatusFilter extends Filter<MaritalStatus> {
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter middleName;

    private StringFilter fathersName;

    private StringFilter secondaryEmail;

    private StringFilter mobileNumber;

    private LocalDateFilter dateOfBirth;

    private GenderFilter gender;

    private MaritalStatusFilter maritalStatus;

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

    public StringFilter getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(StringFilter secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public StringFilter getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(StringFilter mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDateFilter getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateFilter dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GenderFilter getGender() {
        return gender;
    }

    public void setGender(GenderFilter gender) {
        this.gender = gender;
    }

    public MaritalStatusFilter getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusFilter maritalStatus) {
        this.maritalStatus = maritalStatus;
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
            Objects.equals(secondaryEmail, that.secondaryEmail) &&
            Objects.equals(mobileNumber, that.mobileNumber) &&
            Objects.equals(dateOfBirth, that.dateOfBirth) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(maritalStatus, that.maritalStatus) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        middleName,
        fathersName,
        secondaryEmail,
        mobileNumber,
        dateOfBirth,
        gender,
        maritalStatus,
        userId
        );
    }

    @Override
    public String toString() {
        return "UserProfileCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (middleName != null ? "middleName=" + middleName + ", " : "") +
                (fathersName != null ? "fathersName=" + fathersName + ", " : "") +
                (secondaryEmail != null ? "secondaryEmail=" + secondaryEmail + ", " : "") +
                (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
                (dateOfBirth != null ? "dateOfBirth=" + dateOfBirth + ", " : "") +
                (gender != null ? "gender=" + gender + ", " : "") +
                (maritalStatus != null ? "maritalStatus=" + maritalStatus + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
