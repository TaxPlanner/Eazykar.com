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

import com.eazykar.portal.domain.KeyInformation;
import com.eazykar.portal.domain.*; // for static metamodels
import com.eazykar.portal.repository.KeyInformationRepository;
import com.eazykar.portal.service.dto.KeyInformationCriteria;

/**
 * Service for executing complex queries for KeyInformation entities in the database.
 * The main input is a {@link KeyInformationCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link KeyInformation} or a {@link Page} of {@link KeyInformation} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class KeyInformationQueryService extends QueryService<KeyInformation> {

    private final Logger log = LoggerFactory.getLogger(KeyInformationQueryService.class);

    private final KeyInformationRepository keyInformationRepository;

    public KeyInformationQueryService(KeyInformationRepository keyInformationRepository) {
        this.keyInformationRepository = keyInformationRepository;
    }

    /**
     * Return a {@link List} of {@link KeyInformation} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<KeyInformation> findByCriteria(KeyInformationCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<KeyInformation> specification = createSpecification(criteria);
        return keyInformationRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link KeyInformation} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<KeyInformation> findByCriteria(KeyInformationCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<KeyInformation> specification = createSpecification(criteria);
        return keyInformationRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(KeyInformationCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<KeyInformation> specification = createSpecification(criteria);
        return keyInformationRepository.count(specification);
    }

    /**
     * Function to convert KeyInformationCriteria to a {@link Specification}
     */
    private Specification<KeyInformation> createSpecification(KeyInformationCriteria criteria) {
        Specification<KeyInformation> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), KeyInformation_.id));
            }
            if (criteria.getPanNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPanNumber(), KeyInformation_.panNumber));
            }
            if (criteria.getAadharNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAadharNumber(), KeyInformation_.aadharNumber));
            }
            if (criteria.getBankAccountNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBankAccountNumber(), KeyInformation_.bankAccountNumber));
            }
            if (criteria.getIfscCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getIfscCode(), KeyInformation_.ifscCode));
            }
            if (criteria.getBankName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBankName(), KeyInformation_.bankName));
            }
            if (criteria.getBankBranch() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBankBranch(), KeyInformation_.bankBranch));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(KeyInformation_.user, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
