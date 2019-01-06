package com.eazykar.portal.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.eazykar.portal.domain.OtherIncome;
import com.eazykar.portal.domain.*; // for static metamodels
import com.eazykar.portal.repository.OtherIncomeRepository;
import com.eazykar.portal.service.dto.OtherIncomeCriteria;

/**
 * Service for executing complex queries for OtherIncome entities in the database.
 * The main input is a {@link OtherIncomeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link OtherIncome} or a {@link Page} of {@link OtherIncome} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class OtherIncomeQueryService extends QueryService<OtherIncome> {

    private final Logger log = LoggerFactory.getLogger(OtherIncomeQueryService.class);

    private final OtherIncomeRepository otherIncomeRepository;

    public OtherIncomeQueryService(OtherIncomeRepository otherIncomeRepository) {
        this.otherIncomeRepository = otherIncomeRepository;
    }

    /**
     * Return a {@link List} of {@link OtherIncome} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<OtherIncome> findByCriteria(OtherIncomeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<OtherIncome> specification = createSpecification(criteria);
        return otherIncomeRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link OtherIncome} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<OtherIncome> findByCriteria(OtherIncomeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<OtherIncome> specification = createSpecification(criteria);
        return otherIncomeRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(OtherIncomeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<OtherIncome> specification = createSpecification(criteria);
        return otherIncomeRepository.count(specification);
    }

    /**
     * Function to convert OtherIncomeCriteria to a {@link Specification}
     */
    private Specification<OtherIncome> createSpecification(OtherIncomeCriteria criteria) {
        Specification<OtherIncome> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), OtherIncome_.id));
            }
            if (criteria.getInterestIncome() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInterestIncome(), OtherIncome_.interestIncome));
            }
            if (criteria.getAnyOtherIncome() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAnyOtherIncome(), OtherIncome_.anyOtherIncome));
            }
            if (criteria.getExemptDividend() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getExemptDividend(), OtherIncome_.exemptDividend));
            }
            if (criteria.getExemptInterest() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getExemptInterest(), OtherIncome_.exemptInterest));
            }
            if (criteria.getExemptOtherIncome() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getExemptOtherIncome(), OtherIncome_.exemptOtherIncome));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(OtherIncome_.user, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
