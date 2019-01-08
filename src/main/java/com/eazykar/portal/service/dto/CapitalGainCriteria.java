package com.eazykar.portal.service.dto;

import java.io.Serializable;
import java.util.Objects;
import com.eazykar.portal.domain.enumeration.ShareType;
import com.eazykar.portal.domain.enumeration.MutualFundType;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the CapitalGain entity. This class is used in CapitalGainResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /capital-gains?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CapitalGainCriteria implements Serializable {
    /**
     * Class for filtering ShareType
     */
    public static class ShareTypeFilter extends Filter<ShareType> {
    }
    /**
     * Class for filtering MutualFundType
     */
    public static class MutualFundTypeFilter extends Filter<MutualFundType> {
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private ShareTypeFilter shareType;

    private LocalDateFilter shareDateOfSale;

    private LocalDateFilter shareDateOfPurchase;

    private MutualFundTypeFilter mutualFundType;

    private LocalDateFilter mutualFundDateOfSale;

    private LocalDateFilter mutualFundDateOfPurchase;

    private LocalDateFilter otherThanSharesDateOfSale;

    private LocalDateFilter otherThanSharesDateOfPurchase;

    private StringFilter landBuilding;

    private LongFilter userId;

    public CapitalGainCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public ShareTypeFilter getShareType() {
        return shareType;
    }

    public void setShareType(ShareTypeFilter shareType) {
        this.shareType = shareType;
    }

    public LocalDateFilter getShareDateOfSale() {
        return shareDateOfSale;
    }

    public void setShareDateOfSale(LocalDateFilter shareDateOfSale) {
        this.shareDateOfSale = shareDateOfSale;
    }

    public LocalDateFilter getShareDateOfPurchase() {
        return shareDateOfPurchase;
    }

    public void setShareDateOfPurchase(LocalDateFilter shareDateOfPurchase) {
        this.shareDateOfPurchase = shareDateOfPurchase;
    }

    public MutualFundTypeFilter getMutualFundType() {
        return mutualFundType;
    }

    public void setMutualFundType(MutualFundTypeFilter mutualFundType) {
        this.mutualFundType = mutualFundType;
    }

    public LocalDateFilter getMutualFundDateOfSale() {
        return mutualFundDateOfSale;
    }

    public void setMutualFundDateOfSale(LocalDateFilter mutualFundDateOfSale) {
        this.mutualFundDateOfSale = mutualFundDateOfSale;
    }

    public LocalDateFilter getMutualFundDateOfPurchase() {
        return mutualFundDateOfPurchase;
    }

    public void setMutualFundDateOfPurchase(LocalDateFilter mutualFundDateOfPurchase) {
        this.mutualFundDateOfPurchase = mutualFundDateOfPurchase;
    }

    public LocalDateFilter getOtherThanSharesDateOfSale() {
        return otherThanSharesDateOfSale;
    }

    public void setOtherThanSharesDateOfSale(LocalDateFilter otherThanSharesDateOfSale) {
        this.otherThanSharesDateOfSale = otherThanSharesDateOfSale;
    }

    public LocalDateFilter getOtherThanSharesDateOfPurchase() {
        return otherThanSharesDateOfPurchase;
    }

    public void setOtherThanSharesDateOfPurchase(LocalDateFilter otherThanSharesDateOfPurchase) {
        this.otherThanSharesDateOfPurchase = otherThanSharesDateOfPurchase;
    }

    public StringFilter getLandBuilding() {
        return landBuilding;
    }

    public void setLandBuilding(StringFilter landBuilding) {
        this.landBuilding = landBuilding;
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
        final CapitalGainCriteria that = (CapitalGainCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(shareType, that.shareType) &&
            Objects.equals(shareDateOfSale, that.shareDateOfSale) &&
            Objects.equals(shareDateOfPurchase, that.shareDateOfPurchase) &&
            Objects.equals(mutualFundType, that.mutualFundType) &&
            Objects.equals(mutualFundDateOfSale, that.mutualFundDateOfSale) &&
            Objects.equals(mutualFundDateOfPurchase, that.mutualFundDateOfPurchase) &&
            Objects.equals(otherThanSharesDateOfSale, that.otherThanSharesDateOfSale) &&
            Objects.equals(otherThanSharesDateOfPurchase, that.otherThanSharesDateOfPurchase) &&
            Objects.equals(landBuilding, that.landBuilding) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        shareType,
        shareDateOfSale,
        shareDateOfPurchase,
        mutualFundType,
        mutualFundDateOfSale,
        mutualFundDateOfPurchase,
        otherThanSharesDateOfSale,
        otherThanSharesDateOfPurchase,
        landBuilding,
        userId
        );
    }

    @Override
    public String toString() {
        return "CapitalGainCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (shareType != null ? "shareType=" + shareType + ", " : "") +
                (shareDateOfSale != null ? "shareDateOfSale=" + shareDateOfSale + ", " : "") +
                (shareDateOfPurchase != null ? "shareDateOfPurchase=" + shareDateOfPurchase + ", " : "") +
                (mutualFundType != null ? "mutualFundType=" + mutualFundType + ", " : "") +
                (mutualFundDateOfSale != null ? "mutualFundDateOfSale=" + mutualFundDateOfSale + ", " : "") +
                (mutualFundDateOfPurchase != null ? "mutualFundDateOfPurchase=" + mutualFundDateOfPurchase + ", " : "") +
                (otherThanSharesDateOfSale != null ? "otherThanSharesDateOfSale=" + otherThanSharesDateOfSale + ", " : "") +
                (otherThanSharesDateOfPurchase != null ? "otherThanSharesDateOfPurchase=" + otherThanSharesDateOfPurchase + ", " : "") +
                (landBuilding != null ? "landBuilding=" + landBuilding + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
