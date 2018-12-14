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

import com.eazykar.portal.domain.ItrApplication;
import com.eazykar.portal.domain.ItrApplication_;
import com.eazykar.portal.domain.User_;
import com.eazykar.portal.repository.ItrApplicationRepository;
import com.eazykar.portal.service.dto.ItrApplicationCriteria;

import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for ItrApplication entities in the database.
 * The main input is a {@link ItrApplicationCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ItrApplication} or a {@link Page} of {@link ItrApplication} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ItrApplicationQueryService extends QueryService<ItrApplication> {

    private final Logger log = LoggerFactory.getLogger(ItrApplicationQueryService.class);

    private final ItrApplicationRepository itrApplicationRepository;

    public ItrApplicationQueryService(ItrApplicationRepository itrApplicationRepository) {
        this.itrApplicationRepository = itrApplicationRepository;
    }

    /**
     * Return a {@link List} of {@link ItrApplication} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ItrApplication> findByCriteria(ItrApplicationCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ItrApplication> specification = createSpecification(criteria);
        return itrApplicationRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link ItrApplication} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ItrApplication> findByCriteria(ItrApplicationCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ItrApplication> specification = createSpecification(criteria);
        return itrApplicationRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ItrApplicationCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ItrApplication> specification = createSpecification(criteria);
        return itrApplicationRepository.count(specification);
    }

    /**
     * Function to convert ItrApplicationCriteria to a {@link Specification}
     */
    private Specification<ItrApplication> createSpecification(ItrApplicationCriteria criteria) {
        Specification<ItrApplication> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), ItrApplication_.id));
            }
            if (criteria.getApplicationNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getApplicationNumber(), ItrApplication_.applicationNumber));
            }
            if (criteria.getAssessmentYear() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAssessmentYear(), ItrApplication_.assessmentYear));
            }
            if (criteria.getApplicationStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getApplicationStatus(), ItrApplication_.applicationStatus));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(ItrApplication_.user, JoinType.LEFT).get(User_.id)));
            }
            if (criteria.getAssigneeId() != null) {
                specification = specification.and(buildSpecification(criteria.getAssigneeId(),
                    root -> root.join(ItrApplication_.assignee, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
