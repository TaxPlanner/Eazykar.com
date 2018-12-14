package com.eazykar.portal.service.dto;

import java.io.Serializable;
import java.util.Objects;
import com.eazykar.portal.domain.enumeration.ItrApplicationStatus;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the ItrApplication entity. This class is used in ItrApplicationResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /itr-applications?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ItrApplicationCriteria implements Serializable {
    /**
     * Class for filtering ItrApplicationStatus
     */
    public static class ItrApplicationStatusFilter extends Filter<ItrApplicationStatus> {
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter applicationNumber;

    private StringFilter assessmentYear;

    private ItrApplicationStatusFilter applicationStatus;

    private LongFilter userId;

    public ItrApplicationCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(StringFilter applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public StringFilter getAssessmentYear() {
        return assessmentYear;
    }

    public void setAssessmentYear(StringFilter assessmentYear) {
        this.assessmentYear = assessmentYear;
    }

    public ItrApplicationStatusFilter getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ItrApplicationStatusFilter applicationStatus) {
        this.applicationStatus = applicationStatus;
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
        final ItrApplicationCriteria that = (ItrApplicationCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(applicationNumber, that.applicationNumber) &&
            Objects.equals(assessmentYear, that.assessmentYear) &&
            Objects.equals(applicationStatus, that.applicationStatus) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        applicationNumber,
        assessmentYear,
        applicationStatus,
        userId
        );
    }

    @Override
    public String toString() {
        return "ItrApplicationCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (applicationNumber != null ? "applicationNumber=" + applicationNumber + ", " : "") +
                (assessmentYear != null ? "assessmentYear=" + assessmentYear + ", " : "") +
                (applicationStatus != null ? "applicationStatus=" + applicationStatus + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
