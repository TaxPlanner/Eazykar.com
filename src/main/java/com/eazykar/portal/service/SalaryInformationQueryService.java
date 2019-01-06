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

import com.eazykar.portal.domain.SalaryInformation;
import com.eazykar.portal.domain.*; // for static metamodels
import com.eazykar.portal.repository.SalaryInformationRepository;
import com.eazykar.portal.service.dto.SalaryInformationCriteria;

/**
 * Service for executing complex queries for SalaryInformation entities in the database.
 * The main input is a {@link SalaryInformationCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SalaryInformation} or a {@link Page} of {@link SalaryInformation} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SalaryInformationQueryService extends QueryService<SalaryInformation> {

    private final Logger log = LoggerFactory.getLogger(SalaryInformationQueryService.class);

    private final SalaryInformationRepository salaryInformationRepository;

    public SalaryInformationQueryService(SalaryInformationRepository salaryInformationRepository) {
        this.salaryInformationRepository = salaryInformationRepository;
    }

    /**
     * Return a {@link List} of {@link SalaryInformation} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SalaryInformation> findByCriteria(SalaryInformationCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<SalaryInformation> specification = createSpecification(criteria);
        return salaryInformationRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link SalaryInformation} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<SalaryInformation> findByCriteria(SalaryInformationCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<SalaryInformation> specification = createSpecification(criteria);
        return salaryInformationRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SalaryInformationCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<SalaryInformation> specification = createSpecification(criteria);
        return salaryInformationRepository.count(specification);
    }

    /**
     * Function to convert SalaryInformationCriteria to a {@link Specification}
     */
    private Specification<SalaryInformation> createSpecification(SalaryInformationCriteria criteria) {
        Specification<SalaryInformation> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), SalaryInformation_.id));
            }
            if (criteria.getEmployerName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmployerName(), SalaryInformation_.employerName));
            }
            if (criteria.getEmployerType() != null) {
                specification = specification.and(buildSpecification(criteria.getEmployerType(), SalaryInformation_.employerType));
            }
            if (criteria.getEmployerTan() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmployerTan(), SalaryInformation_.employerTan));
            }
            if (criteria.getIncome() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIncome(), SalaryInformation_.income));
            }
            if (criteria.getTds() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTds(), SalaryInformation_.tds));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(SalaryInformation_.user, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
