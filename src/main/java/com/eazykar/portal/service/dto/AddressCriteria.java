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
 * Criteria class for the Address entity. This class is used in AddressResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /addresses?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AddressCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter line1;

    private StringFilter line2;

    private StringFilter line3;

    private StringFilter line4;

    private StringFilter city;

    private StringFilter state;

    private StringFilter country;

    private StringFilter postalCode;

    private LongFilter userId;

    public AddressCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getLine1() {
        return line1;
    }

    public void setLine1(StringFilter line1) {
        this.line1 = line1;
    }

    public StringFilter getLine2() {
        return line2;
    }

    public void setLine2(StringFilter line2) {
        this.line2 = line2;
    }

    public StringFilter getLine3() {
        return line3;
    }

    public void setLine3(StringFilter line3) {
        this.line3 = line3;
    }

    public StringFilter getLine4() {
        return line4;
    }

    public void setLine4(StringFilter line4) {
        this.line4 = line4;
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

    public StringFilter getCountry() {
        return country;
    }

    public void setCountry(StringFilter country) {
        this.country = country;
    }

    public StringFilter getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(StringFilter postalCode) {
        this.postalCode = postalCode;
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
        final AddressCriteria that = (AddressCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(line1, that.line1) &&
            Objects.equals(line2, that.line2) &&
            Objects.equals(line3, that.line3) &&
            Objects.equals(line4, that.line4) &&
            Objects.equals(city, that.city) &&
            Objects.equals(state, that.state) &&
            Objects.equals(country, that.country) &&
            Objects.equals(postalCode, that.postalCode) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        line1,
        line2,
        line3,
        line4,
        city,
        state,
        country,
        postalCode,
        userId
        );
    }

    @Override
    public String toString() {
        return "AddressCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (line1 != null ? "line1=" + line1 + ", " : "") +
                (line2 != null ? "line2=" + line2 + ", " : "") +
                (line3 != null ? "line3=" + line3 + ", " : "") +
                (line4 != null ? "line4=" + line4 + ", " : "") +
                (city != null ? "city=" + city + ", " : "") +
                (state != null ? "state=" + state + ", " : "") +
                (country != null ? "country=" + country + ", " : "") +
                (postalCode != null ? "postalCode=" + postalCode + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
