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

import com.eazykar.portal.domain.Plan_;
import com.eazykar.portal.domain.UserPlan;
import com.eazykar.portal.domain.UserPlan_;
import com.eazykar.portal.domain.User_;
import com.eazykar.portal.repository.UserPlanRepository;
import com.eazykar.portal.service.dto.UserPlanCriteria;

import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for UserPlan entities in the database.
 * The main input is a {@link UserPlanCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link UserPlan} or a {@link Page} of {@link UserPlan} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UserPlanQueryService extends QueryService<UserPlan> {

    private final Logger log = LoggerFactory.getLogger(UserPlanQueryService.class);

    private final UserPlanRepository userPlanRepository;

    public UserPlanQueryService(UserPlanRepository userPlanRepository) {
        this.userPlanRepository = userPlanRepository;
    }

    /**
     * Return a {@link List} of {@link UserPlan} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<UserPlan> findByCriteria(UserPlanCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<UserPlan> specification = createSpecification(criteria);
        return userPlanRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link UserPlan} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<UserPlan> findByCriteria(UserPlanCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<UserPlan> specification = createSpecification(criteria);
        return userPlanRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UserPlanCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<UserPlan> specification = createSpecification(criteria);
        return userPlanRepository.count(specification);
    }

    /**
     * Function to convert UserPlanCriteria to a {@link Specification}
     */
    private Specification<UserPlan> createSpecification(UserPlanCriteria criteria) {
        Specification<UserPlan> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), UserPlan_.id));
            }
            if (criteria.getPurchasedOn() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPurchasedOn(), UserPlan_.purchasedOn));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(UserPlan_.user, JoinType.LEFT).get(User_.id)));
            }
            if (criteria.getPlanId() != null) {
                specification = specification.and(buildSpecification(criteria.getPlanId(),
                    root -> root.join(UserPlan_.plan, JoinType.LEFT).get(Plan_.id)));
            }
        }
        return specification;
    }
}
