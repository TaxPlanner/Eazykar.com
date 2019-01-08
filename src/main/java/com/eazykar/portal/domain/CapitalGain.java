package com.eazykar.portal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.eazykar.portal.domain.enumeration.ShareType;

import com.eazykar.portal.domain.enumeration.MutualFundType;

/**
 * A CapitalGain.
 */
@Entity
@Table(name = "capital_gain")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CapitalGain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "share_type")
    private ShareType shareType;

    @Column(name = "share_date_of_sale")
    private LocalDate shareDateOfSale;

    @Column(name = "share_date_of_purchase")
    private LocalDate shareDateOfPurchase;

    @Enumerated(EnumType.STRING)
    @Column(name = "mutual_fund_type")
    private MutualFundType mutualFundType;

    @Column(name = "mutual_fund_date_of_sale")
    private LocalDate mutualFundDateOfSale;

    @Column(name = "mutual_fund_date_of_purchase")
    private LocalDate mutualFundDateOfPurchase;

    @Column(name = "other_than_shares_date_of_sale")
    private LocalDate otherThanSharesDateOfSale;

    @Column(name = "other_than_shares_date_of_purchase")
    private LocalDate otherThanSharesDateOfPurchase;

    @Size(max = 1000)
    @Column(name = "land_building", length = 1000)
    private String landBuilding;

    @OneToOne(optional = false)    @NotNull
    @JoinColumn(unique = true)
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShareType getShareType() {
        return shareType;
    }

    public CapitalGain shareType(ShareType shareType) {
        this.shareType = shareType;
        return this;
    }

    public void setShareType(ShareType shareType) {
        this.shareType = shareType;
    }

    public LocalDate getShareDateOfSale() {
        return shareDateOfSale;
    }

    public CapitalGain shareDateOfSale(LocalDate shareDateOfSale) {
        this.shareDateOfSale = shareDateOfSale;
        return this;
    }

    public void setShareDateOfSale(LocalDate shareDateOfSale) {
        this.shareDateOfSale = shareDateOfSale;
    }

    public LocalDate getShareDateOfPurchase() {
        return shareDateOfPurchase;
    }

    public CapitalGain shareDateOfPurchase(LocalDate shareDateOfPurchase) {
        this.shareDateOfPurchase = shareDateOfPurchase;
        return this;
    }

    public void setShareDateOfPurchase(LocalDate shareDateOfPurchase) {
        this.shareDateOfPurchase = shareDateOfPurchase;
    }

    public MutualFundType getMutualFundType() {
        return mutualFundType;
    }

    public CapitalGain mutualFundType(MutualFundType mutualFundType) {
        this.mutualFundType = mutualFundType;
        return this;
    }

    public void setMutualFundType(MutualFundType mutualFundType) {
        this.mutualFundType = mutualFundType;
    }

    public LocalDate getMutualFundDateOfSale() {
        return mutualFundDateOfSale;
    }

    public CapitalGain mutualFundDateOfSale(LocalDate mutualFundDateOfSale) {
        this.mutualFundDateOfSale = mutualFundDateOfSale;
        return this;
    }

    public void setMutualFundDateOfSale(LocalDate mutualFundDateOfSale) {
        this.mutualFundDateOfSale = mutualFundDateOfSale;
    }

    public LocalDate getMutualFundDateOfPurchase() {
        return mutualFundDateOfPurchase;
    }

    public CapitalGain mutualFundDateOfPurchase(LocalDate mutualFundDateOfPurchase) {
        this.mutualFundDateOfPurchase = mutualFundDateOfPurchase;
        return this;
    }

    public void setMutualFundDateOfPurchase(LocalDate mutualFundDateOfPurchase) {
        this.mutualFundDateOfPurchase = mutualFundDateOfPurchase;
    }

    public LocalDate getOtherThanSharesDateOfSale() {
        return otherThanSharesDateOfSale;
    }

    public CapitalGain otherThanSharesDateOfSale(LocalDate otherThanSharesDateOfSale) {
        this.otherThanSharesDateOfSale = otherThanSharesDateOfSale;
        return this;
    }

    public void setOtherThanSharesDateOfSale(LocalDate otherThanSharesDateOfSale) {
        this.otherThanSharesDateOfSale = otherThanSharesDateOfSale;
    }

    public LocalDate getOtherThanSharesDateOfPurchase() {
        return otherThanSharesDateOfPurchase;
    }

    public CapitalGain otherThanSharesDateOfPurchase(LocalDate otherThanSharesDateOfPurchase) {
        this.otherThanSharesDateOfPurchase = otherThanSharesDateOfPurchase;
        return this;
    }

    public void setOtherThanSharesDateOfPurchase(LocalDate otherThanSharesDateOfPurchase) {
        this.otherThanSharesDateOfPurchase = otherThanSharesDateOfPurchase;
    }

    public String getLandBuilding() {
        return landBuilding;
    }

    public CapitalGain landBuilding(String landBuilding) {
        this.landBuilding = landBuilding;
        return this;
    }

    public void setLandBuilding(String landBuilding) {
        this.landBuilding = landBuilding;
    }

    public User getUser() {
        return user;
    }

    public CapitalGain user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CapitalGain capitalGain = (CapitalGain) o;
        if (capitalGain.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), capitalGain.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CapitalGain{" +
            "id=" + getId() +
            ", shareType='" + getShareType() + "'" +
            ", shareDateOfSale='" + getShareDateOfSale() + "'" +
            ", shareDateOfPurchase='" + getShareDateOfPurchase() + "'" +
            ", mutualFundType='" + getMutualFundType() + "'" +
            ", mutualFundDateOfSale='" + getMutualFundDateOfSale() + "'" +
            ", mutualFundDateOfPurchase='" + getMutualFundDateOfPurchase() + "'" +
            ", otherThanSharesDateOfSale='" + getOtherThanSharesDateOfSale() + "'" +
            ", otherThanSharesDateOfPurchase='" + getOtherThanSharesDateOfPurchase() + "'" +
            ", landBuilding='" + getLandBuilding() + "'" +
            "}";
    }
}
