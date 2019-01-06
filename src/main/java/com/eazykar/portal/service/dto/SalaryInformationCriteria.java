package com.eazykar.portal.service.dto;

import java.io.Serializable;
import java.util.Objects;
import com.eazykar.portal.domain.enumeration.EmployerType;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.BigDecimalFilter;

/**
 * Criteria class for the SalaryInformation entity. This class is used in SalaryInformationResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /salary-informations?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class SalaryInformationCriteria implements Serializable {
    /**
     * Class for filtering EmployerType
     */
    public static class EmployerTypeFilter extends Filter<EmployerType> {
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter employerName;

    private EmployerTypeFilter employerType;

    private StringFilter employerTan;

    private BigDecimalFilter income;

    private BigDecimalFilter tds;

    private LongFilter userId;

    public SalaryInformationCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getEmployerName() {
        return employerName;
    }

    public void setEmployerName(StringFilter employerName) {
        this.employerName = employerName;
    }

    public EmployerTypeFilter getEmployerType() {
        return employerType;
    }

    public void setEmployerType(EmployerTypeFilter employerType) {
        this.employerType = employerType;
    }

    public StringFilter getEmployerTan() {
        return employerTan;
    }

    public void setEmployerTan(StringFilter employerTan) {
        this.employerTan = employerTan;
    }

    public BigDecimalFilter getIncome() {
        return income;
    }

    public void setIncome(BigDecimalFilter income) {
        this.income = income;
    }

    public BigDecimalFilter getTds() {
        return tds;
    }

    public void setTds(BigDecimalFilter tds) {
        this.tds = tds;
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
        final SalaryInformationCriteria that = (SalaryInformationCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(employerName, that.employerName) &&
            Objects.equals(employerType, that.employerType) &&
            Objects.equals(employerTan, that.employerTan) &&
            Objects.equals(income, that.income) &&
            Objects.equals(tds, that.tds) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        employerName,
        employerType,
        employerTan,
        income,
        tds,
        userId
        );
    }

    @Override
    public String toString() {
        return "SalaryInformationCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (employerName != null ? "employerName=" + employerName + ", " : "") +
                (employerType != null ? "employerType=" + employerType + ", " : "") +
                (employerTan != null ? "employerTan=" + employerTan + ", " : "") +
                (income != null ? "income=" + income + ", " : "") +
                (tds != null ? "tds=" + tds + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
