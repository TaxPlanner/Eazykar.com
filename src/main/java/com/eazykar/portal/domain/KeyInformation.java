package com.eazykar.portal.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A KeyInformation.
 */
@Entity
@Table(name = "key_information")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class KeyInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[A-Za-z]{5}\\d{4}[A-Za-z]{1}")
    @Column(name = "pan_number", length = 10, nullable = false, unique = true)
    private String panNumber;

    @Size(max = 20)
    @Column(name = "aadhar_number", length = 20)
    private String aadharNumber;

    @Size(max = 20)
    @Column(name = "bank_account_number", length = 20)
    private String bankAccountNumber;

    @Size(max = 20)
    @Column(name = "ifsc_code", length = 20)
    private String ifscCode;

    @Size(max = 200)
    @Column(name = "bank_name", length = 200)
    private String bankName;

    @Size(max = 200)
    @Column(name = "bank_branch", length = 200)
    private String bankBranch;

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

    public String getPanNumber() {
        return panNumber;
    }

    public KeyInformation panNumber(String panNumber) {
        this.panNumber = panNumber;
        return this;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public KeyInformation aadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
        return this;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public KeyInformation bankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public KeyInformation ifscCode(String ifscCode) {
        this.ifscCode = ifscCode;
        return this;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public KeyInformation bankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public KeyInformation bankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
        return this;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public User getUser() {
        return user;
    }

    public KeyInformation user(User user) {
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
        KeyInformation keyInformation = (KeyInformation) o;
        if (keyInformation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), keyInformation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "KeyInformation{" +
            "id=" + getId() +
            ", panNumber='" + getPanNumber() + "'" +
            ", aadharNumber='" + getAadharNumber() + "'" +
            ", bankAccountNumber='" + getBankAccountNumber() + "'" +
            ", ifscCode='" + getIfscCode() + "'" +
            ", bankName='" + getBankName() + "'" +
            ", bankBranch='" + getBankBranch() + "'" +
            "}";
    }
}
