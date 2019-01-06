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
 * Criteria class for the HouseProperty entity. This class is used in HousePropertyResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /house-properties?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class HousePropertyCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter address;

    private StringFilter tenant;

    private BigDecimalFilter propertyTax;

    private BigDecimalFilter housingLoanInterest;

    private LongFilter userId;

    public HousePropertyCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAddress() {
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public StringFilter getTenant() {
        return tenant;
    }

    public void setTenant(StringFilter tenant) {
        this.tenant = tenant;
    }

    public BigDecimalFilter getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(BigDecimalFilter propertyTax) {
        this.propertyTax = propertyTax;
    }

    public BigDecimalFilter getHousingLoanInterest() {
        return housingLoanInterest;
    }

    public void setHousingLoanInterest(BigDecimalFilter housingLoanInterest) {
        this.housingLoanInterest = housingLoanInterest;
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
        final HousePropertyCriteria that = (HousePropertyCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(address, that.address) &&
            Objects.equals(tenant, that.tenant) &&
            Objects.equals(propertyTax, that.propertyTax) &&
            Objects.equals(housingLoanInterest, that.housingLoanInterest) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        address,
        tenant,
        propertyTax,
        housingLoanInterest,
        userId
        );
    }

    @Override
    public String toString() {
        return "HousePropertyCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (address != null ? "address=" + address + ", " : "") +
                (tenant != null ? "tenant=" + tenant + ", " : "") +
                (propertyTax != null ? "propertyTax=" + propertyTax + ", " : "") +
                (housingLoanInterest != null ? "housingLoanInterest=" + housingLoanInterest + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
