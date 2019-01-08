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

import com.eazykar.portal.domain.CapitalGain;
import com.eazykar.portal.domain.*; // for static metamodels
import com.eazykar.portal.repository.CapitalGainRepository;
import com.eazykar.portal.service.dto.CapitalGainCriteria;

/**
 * Service for executing complex queries for CapitalGain entities in the database.
 * The main input is a {@link CapitalGainCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CapitalGain} or a {@link Page} of {@link CapitalGain} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CapitalGainQueryService extends QueryService<CapitalGain> {

    private final Logger log = LoggerFactory.getLogger(CapitalGainQueryService.class);

    private final CapitalGainRepository capitalGainRepository;

    public CapitalGainQueryService(CapitalGainRepository capitalGainRepository) {
        this.capitalGainRepository = capitalGainRepository;
    }

    /**
     * Return a {@link List} of {@link CapitalGain} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CapitalGain> findByCriteria(CapitalGainCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<CapitalGain> specification = createSpecification(criteria);
        return capitalGainRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link CapitalGain} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CapitalGain> findByCriteria(CapitalGainCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<CapitalGain> specification = createSpecification(criteria);
        return capitalGainRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CapitalGainCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<CapitalGain> specification = createSpecification(criteria);
        return capitalGainRepository.count(specification);
    }

    /**
     * Function to convert CapitalGainCriteria to a {@link Specification}
     */
    private Specification<CapitalGain> createSpecification(CapitalGainCriteria criteria) {
        Specification<CapitalGain> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), CapitalGain_.id));
            }
            if (criteria.getShareType() != null) {
                specification = specification.and(buildSpecification(criteria.getShareType(), CapitalGain_.shareType));
            }
            if (criteria.getShareDateOfSale() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getShareDateOfSale(), CapitalGain_.shareDateOfSale));
            }
            if (criteria.getShareDateOfPurchase() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getShareDateOfPurchase(), CapitalGain_.shareDateOfPurchase));
            }
            if (criteria.getMutualFundType() != null) {
                specification = specification.and(buildSpecification(criteria.getMutualFundType(), CapitalGain_.mutualFundType));
            }
            if (criteria.getMutualFundDateOfSale() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getMutualFundDateOfSale(), CapitalGain_.mutualFundDateOfSale));
            }
            if (criteria.getMutualFundDateOfPurchase() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getMutualFundDateOfPurchase(), CapitalGain_.mutualFundDateOfPurchase));
            }
            if (criteria.getOtherThanSharesDateOfSale() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getOtherThanSharesDateOfSale(), CapitalGain_.otherThanSharesDateOfSale));
            }
            if (criteria.getOtherThanSharesDateOfPurchase() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getOtherThanSharesDateOfPurchase(), CapitalGain_.otherThanSharesDateOfPurchase));
            }
            if (criteria.getLandBuilding() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLandBuilding(), CapitalGain_.landBuilding));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(CapitalGain_.user, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
