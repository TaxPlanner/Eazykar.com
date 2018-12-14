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

import com.eazykar.portal.domain.Plan;
import com.eazykar.portal.domain.*; // for static metamodels
import com.eazykar.portal.repository.PlanRepository;
import com.eazykar.portal.service.dto.PlanCriteria;

/**
 * Service for executing complex queries for Plan entities in the database.
 * The main input is a {@link PlanCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Plan} or a {@link Page} of {@link Plan} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PlanQueryService extends QueryService<Plan> {

    private final Logger log = LoggerFactory.getLogger(PlanQueryService.class);

    private final PlanRepository planRepository;

    public PlanQueryService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    /**
     * Return a {@link List} of {@link Plan} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Plan> findByCriteria(PlanCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Plan> specification = createSpecification(criteria);
        return planRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Plan} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Plan> findByCriteria(PlanCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Plan> specification = createSpecification(criteria);
        return planRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PlanCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Plan> specification = createSpecification(criteria);
        return planRepository.count(specification);
    }

    /**
     * Function to convert PlanCriteria to a {@link Specification}
     */
    private Specification<Plan> createSpecification(PlanCriteria criteria) {
        Specification<Plan> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), Plan_.id));
            }
            if (criteria.getPlanNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPlanNumber(), Plan_.planNumber));
            }
            if (criteria.getPlanName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPlanName(), Plan_.planName));
            }
            if (criteria.getPlanType() != null) {
                specification = specification.and(buildSpecification(criteria.getPlanType(), Plan_.planType));
            }
            if (criteria.getPlanFees() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPlanFees(), Plan_.planFees));
            }
            if (criteria.getActive() != null) {
                specification = specification.and(buildSpecification(criteria.getActive(), Plan_.active));
            }
        }
        return specification;
    }
}
