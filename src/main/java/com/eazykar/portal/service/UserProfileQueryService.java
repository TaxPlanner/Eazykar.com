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

import com.eazykar.portal.domain.UserProfile;
import com.eazykar.portal.domain.UserProfile_;
import com.eazykar.portal.domain.User_;
import com.eazykar.portal.repository.UserProfileRepository;
import com.eazykar.portal.service.dto.UserProfileCriteria;

import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for UserProfile entities in the database.
 * The main input is a {@link UserProfileCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link UserProfile} or a {@link Page} of {@link UserProfile} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UserProfileQueryService extends QueryService<UserProfile> {

    private final Logger log = LoggerFactory.getLogger(UserProfileQueryService.class);

    private final UserProfileRepository userProfileRepository;

    public UserProfileQueryService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    /**
     * Return a {@link List} of {@link UserProfile} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<UserProfile> findByCriteria(UserProfileCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<UserProfile> specification = createSpecification(criteria);
        return userProfileRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link UserProfile} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<UserProfile> findByCriteria(UserProfileCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<UserProfile> specification = createSpecification(criteria);
        return userProfileRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UserProfileCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<UserProfile> specification = createSpecification(criteria);
        return userProfileRepository.count(specification);
    }

    /**
     * Function to convert UserProfileCriteria to a {@link Specification}
     */
    private Specification<UserProfile> createSpecification(UserProfileCriteria criteria) {
        Specification<UserProfile> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), UserProfile_.id));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMiddleName(), UserProfile_.middleName));
            }
            if (criteria.getFathersName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFathersName(), UserProfile_.fathersName));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobileNumber(), UserProfile_.mobileNumber));
            }
            if (criteria.getPanNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPanNumber(), UserProfile_.panNumber));
            }
            if (criteria.getAddressLine1() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddressLine1(), UserProfile_.addressLine1));
            }
            if (criteria.getAddressLine2() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddressLine2(), UserProfile_.addressLine2));
            }
            if (criteria.getAddressLine3() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddressLine3(), UserProfile_.addressLine3));
            }
            if (criteria.getAddressLine4() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddressLine4(), UserProfile_.addressLine4));
            }
            if (criteria.getCity() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCity(), UserProfile_.city));
            }
            if (criteria.getState() != null) {
                specification = specification.and(buildStringSpecification(criteria.getState(), UserProfile_.state));
            }
            if (criteria.getPinCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPinCode(), UserProfile_.pinCode));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(UserProfile_.user, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
