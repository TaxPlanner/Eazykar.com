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
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the UserPlan entity. This class is used in UserPlanResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /user-plans?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class UserPlanCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LocalDateFilter purchasedOn;

    private LongFilter userId;

    private LongFilter planId;

    public UserPlanCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LocalDateFilter getPurchasedOn() {
        return purchasedOn;
    }

    public void setPurchasedOn(LocalDateFilter purchasedOn) {
        this.purchasedOn = purchasedOn;
    }

    public LongFilter getUserId() {
        return userId;
    }

    public void setUserId(LongFilter userId) {
        this.userId = userId;
    }

    public LongFilter getPlanId() {
        return planId;
    }

    public void setPlanId(LongFilter planId) {
        this.planId = planId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserPlanCriteria that = (UserPlanCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(purchasedOn, that.purchasedOn) &&
            Objects.equals(userId, that.userId) &&
            Objects.equals(planId, that.planId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        purchasedOn,
        userId,
        planId
        );
    }

    @Override
    public String toString() {
        return "UserPlanCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (purchasedOn != null ? "purchasedOn=" + purchasedOn + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
                (planId != null ? "planId=" + planId + ", " : "") +
            "}";
    }

}
