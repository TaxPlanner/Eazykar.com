package com.eazykar.portal.service.dto;

import java.io.Serializable;
import java.util.Objects;

import com.eazykar.portal.domain.enumeration.PlanType;

import io.github.jhipster.service.filter.BigDecimalFilter;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the Plan entity. This class is used in PlanResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /plans?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PlanCriteria implements Serializable {
    /**
     * Class for filtering PlanType
     */
    public static class PlanTypeFilter extends Filter<PlanType> {
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter planNumber;

    private StringFilter planName;

    private PlanTypeFilter planType;

    private BigDecimalFilter planFees;

    private BooleanFilter active;

    public PlanCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(StringFilter planNumber) {
        this.planNumber = planNumber;
    }

    public StringFilter getPlanName() {
        return planName;
    }

    public void setPlanName(StringFilter planName) {
        this.planName = planName;
    }

    public PlanTypeFilter getPlanType() {
        return planType;
    }

    public void setPlanType(PlanTypeFilter planType) {
        this.planType = planType;
    }

    public BigDecimalFilter getPlanFees() {
        return planFees;
    }

    public void setPlanFees(BigDecimalFilter planFees) {
        this.planFees = planFees;
    }

    public BooleanFilter getActive() {
        return active;
    }

    public void setActive(BooleanFilter active) {
        this.active = active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PlanCriteria that = (PlanCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(planNumber, that.planNumber) &&
            Objects.equals(planName, that.planName) &&
            Objects.equals(planType, that.planType) &&
            Objects.equals(planFees, that.planFees) &&
            Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        planNumber,
        planName,
        planType,
        planFees,
        active
        );
    }

    @Override
    public String toString() {
        return "PlanCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (planNumber != null ? "planNumber=" + planNumber + ", " : "") +
                (planName != null ? "planName=" + planName + ", " : "") +
                (planType != null ? "planType=" + planType + ", " : "") +
                (planFees != null ? "planFees=" + planFees + ", " : "") +
                (active != null ? "active=" + active + ", " : "") +
            "}";
    }

}
