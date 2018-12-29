package com.eazykar.portal.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the KeyInformation entity. This class is used in KeyInformationResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /key-informations?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class KeyInformationCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter panNumber;

    private StringFilter aadharNumber;

    private StringFilter bankAccountNumber;

    private StringFilter ifscCode;

    private StringFilter bankName;

    private StringFilter bankBranch;

    private LongFilter userId;

    public KeyInformationCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(StringFilter panNumber) {
        this.panNumber = panNumber;
    }

    public StringFilter getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(StringFilter aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public StringFilter getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(StringFilter bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public StringFilter getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(StringFilter ifscCode) {
        this.ifscCode = ifscCode;
    }

    public StringFilter getBankName() {
        return bankName;
    }

    public void setBankName(StringFilter bankName) {
        this.bankName = bankName;
    }

    public StringFilter getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(StringFilter bankBranch) {
        this.bankBranch = bankBranch;
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
        final KeyInformationCriteria that = (KeyInformationCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(panNumber, that.panNumber) &&
            Objects.equals(aadharNumber, that.aadharNumber) &&
            Objects.equals(bankAccountNumber, that.bankAccountNumber) &&
            Objects.equals(ifscCode, that.ifscCode) &&
            Objects.equals(bankName, that.bankName) &&
            Objects.equals(bankBranch, that.bankBranch) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        panNumber,
        aadharNumber,
        bankAccountNumber,
        ifscCode,
        bankName,
        bankBranch,
        userId
        );
    }

    @Override
    public String toString() {
        return "KeyInformationCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (panNumber != null ? "panNumber=" + panNumber + ", " : "") +
                (aadharNumber != null ? "aadharNumber=" + aadharNumber + ", " : "") +
                (bankAccountNumber != null ? "bankAccountNumber=" + bankAccountNumber + ", " : "") +
                (ifscCode != null ? "ifscCode=" + ifscCode + ", " : "") +
                (bankName != null ? "bankName=" + bankName + ", " : "") +
                (bankBranch != null ? "bankBranch=" + bankBranch + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
