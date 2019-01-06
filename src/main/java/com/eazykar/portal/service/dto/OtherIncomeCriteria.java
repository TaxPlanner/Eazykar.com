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
import io.github.jhipster.service.filter.BigDecimalFilter;

/**
 * Criteria class for the OtherIncome entity. This class is used in OtherIncomeResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /other-incomes?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class OtherIncomeCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private BigDecimalFilter interestIncome;

    private BigDecimalFilter anyOtherIncome;

    private BigDecimalFilter exemptDividend;

    private BigDecimalFilter exemptInterest;

    private BigDecimalFilter exemptOtherIncome;

    private LongFilter userId;

    public OtherIncomeCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public BigDecimalFilter getInterestIncome() {
        return interestIncome;
    }

    public void setInterestIncome(BigDecimalFilter interestIncome) {
        this.interestIncome = interestIncome;
    }

    public BigDecimalFilter getAnyOtherIncome() {
        return anyOtherIncome;
    }

    public void setAnyOtherIncome(BigDecimalFilter anyOtherIncome) {
        this.anyOtherIncome = anyOtherIncome;
    }

    public BigDecimalFilter getExemptDividend() {
        return exemptDividend;
    }

    public void setExemptDividend(BigDecimalFilter exemptDividend) {
        this.exemptDividend = exemptDividend;
    }

    public BigDecimalFilter getExemptInterest() {
        return exemptInterest;
    }

    public void setExemptInterest(BigDecimalFilter exemptInterest) {
        this.exemptInterest = exemptInterest;
    }

    public BigDecimalFilter getExemptOtherIncome() {
        return exemptOtherIncome;
    }

    public void setExemptOtherIncome(BigDecimalFilter exemptOtherIncome) {
        this.exemptOtherIncome = exemptOtherIncome;
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
        final OtherIncomeCriteria that = (OtherIncomeCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(interestIncome, that.interestIncome) &&
            Objects.equals(anyOtherIncome, that.anyOtherIncome) &&
            Objects.equals(exemptDividend, that.exemptDividend) &&
            Objects.equals(exemptInterest, that.exemptInterest) &&
            Objects.equals(exemptOtherIncome, that.exemptOtherIncome) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        interestIncome,
        anyOtherIncome,
        exemptDividend,
        exemptInterest,
        exemptOtherIncome,
        userId
        );
    }

    @Override
    public String toString() {
        return "OtherIncomeCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (interestIncome != null ? "interestIncome=" + interestIncome + ", " : "") +
                (anyOtherIncome != null ? "anyOtherIncome=" + anyOtherIncome + ", " : "") +
                (exemptDividend != null ? "exemptDividend=" + exemptDividend + ", " : "") +
                (exemptInterest != null ? "exemptInterest=" + exemptInterest + ", " : "") +
                (exemptOtherIncome != null ? "exemptOtherIncome=" + exemptOtherIncome + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
