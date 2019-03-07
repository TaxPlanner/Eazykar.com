package com.eazykar.portal.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.filter.BigDecimalFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the SalaryInformation entity. This class is used in SalaryInformationResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /salary-informations?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class SalaryInformationCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter employerName;

    private StringFilter employerAddress;

    private BigDecimalFilter basicPay;

    private BigDecimalFilter hra;

    private BigDecimalFilter conveyance;

    private BigDecimalFilter medical;

    private BigDecimalFilter lta;

    private BigDecimalFilter others;

    private BigDecimalFilter perquisites;

    private BigDecimalFilter leaveEncashment;

    private BigDecimalFilter gratuity;

    private BigDecimalFilter arrears;

    private BigDecimalFilter professionalTax;

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

    public StringFilter getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(StringFilter employerAddress) {
        this.employerAddress = employerAddress;
    }

    public BigDecimalFilter getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(BigDecimalFilter basicPay) {
        this.basicPay = basicPay;
    }

    public BigDecimalFilter getHra() {
        return hra;
    }

    public void setHra(BigDecimalFilter hra) {
        this.hra = hra;
    }

    public BigDecimalFilter getConveyance() {
        return conveyance;
    }

    public void setConveyance(BigDecimalFilter conveyance) {
        this.conveyance = conveyance;
    }

    public BigDecimalFilter getMedical() {
        return medical;
    }

    public void setMedical(BigDecimalFilter medical) {
        this.medical = medical;
    }

    public BigDecimalFilter getLta() {
        return lta;
    }

    public void setLta(BigDecimalFilter lta) {
        this.lta = lta;
    }

    public BigDecimalFilter getOthers() {
        return others;
    }

    public void setOthers(BigDecimalFilter others) {
        this.others = others;
    }

    public BigDecimalFilter getPerquisites() {
        return perquisites;
    }

    public void setPerquisites(BigDecimalFilter perquisites) {
        this.perquisites = perquisites;
    }

    public BigDecimalFilter getLeaveEncashment() {
        return leaveEncashment;
    }

    public void setLeaveEncashment(BigDecimalFilter leaveEncashment) {
        this.leaveEncashment = leaveEncashment;
    }

    public BigDecimalFilter getGratuity() {
        return gratuity;
    }

    public void setGratuity(BigDecimalFilter gratuity) {
        this.gratuity = gratuity;
    }

    public BigDecimalFilter getArrears() {
        return arrears;
    }

    public void setArrears(BigDecimalFilter arrears) {
        this.arrears = arrears;
    }

    public BigDecimalFilter getProfessionalTax() {
        return professionalTax;
    }

    public void setProfessionalTax(BigDecimalFilter professionalTax) {
        this.professionalTax = professionalTax;
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
            Objects.equals(employerAddress, that.employerAddress) &&
            Objects.equals(basicPay, that.basicPay) &&
            Objects.equals(hra, that.hra) &&
            Objects.equals(conveyance, that.conveyance) &&
            Objects.equals(medical, that.medical) &&
            Objects.equals(lta, that.lta) &&
            Objects.equals(others, that.others) &&
            Objects.equals(perquisites, that.perquisites) &&
            Objects.equals(leaveEncashment, that.leaveEncashment) &&
            Objects.equals(gratuity, that.gratuity) &&
            Objects.equals(arrears, that.arrears) &&
            Objects.equals(professionalTax, that.professionalTax) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        employerName,
        employerAddress,
        basicPay,
        hra,
        conveyance,
        medical,
        lta,
        others,
        perquisites,
        leaveEncashment,
        gratuity,
        arrears,
        professionalTax,
        userId
        );
    }

    @Override
    public String toString() {
        return "SalaryInformationCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (employerName != null ? "employerName=" + employerName + ", " : "") +
                (employerAddress != null ? "employerAddress=" + employerAddress + ", " : "") +
                (basicPay != null ? "basicPay=" + basicPay + ", " : "") +
                (hra != null ? "hra=" + hra + ", " : "") +
                (conveyance != null ? "conveyance=" + conveyance + ", " : "") +
                (medical != null ? "medical=" + medical + ", " : "") +
                (lta != null ? "lta=" + lta + ", " : "") +
                (others != null ? "others=" + others + ", " : "") +
                (perquisites != null ? "perquisites=" + perquisites + ", " : "") +
                (leaveEncashment != null ? "leaveEncashment=" + leaveEncashment + ", " : "") +
                (gratuity != null ? "gratuity=" + gratuity + ", " : "") +
                (arrears != null ? "arrears=" + arrears + ", " : "") +
                (professionalTax != null ? "professionalTax=" + professionalTax + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
