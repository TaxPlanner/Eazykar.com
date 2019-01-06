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

import com.eazykar.portal.domain.HouseProperty;
import com.eazykar.portal.domain.*; // for static metamodels
import com.eazykar.portal.repository.HousePropertyRepository;
import com.eazykar.portal.service.dto.HousePropertyCriteria;

/**
 * Service for executing complex queries for HouseProperty entities in the database.
 * The main input is a {@link HousePropertyCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link HouseProperty} or a {@link Page} of {@link HouseProperty} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class HousePropertyQueryService extends QueryService<HouseProperty> {

    private final Logger log = LoggerFactory.getLogger(HousePropertyQueryService.class);

    private final HousePropertyRepository housePropertyRepository;

    public HousePropertyQueryService(HousePropertyRepository housePropertyRepository) {
        this.housePropertyRepository = housePropertyRepository;
    }

    /**
     * Return a {@link List} of {@link HouseProperty} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<HouseProperty> findByCriteria(HousePropertyCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<HouseProperty> specification = createSpecification(criteria);
        return housePropertyRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link HouseProperty} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<HouseProperty> findByCriteria(HousePropertyCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<HouseProperty> specification = createSpecification(criteria);
        return housePropertyRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(HousePropertyCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<HouseProperty> specification = createSpecification(criteria);
        return housePropertyRepository.count(specification);
    }

    /**
     * Function to convert HousePropertyCriteria to a {@link Specification}
     */
    private Specification<HouseProperty> createSpecification(HousePropertyCriteria criteria) {
        Specification<HouseProperty> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), HouseProperty_.id));
            }
            if (criteria.getAddress() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddress(), HouseProperty_.address));
            }
            if (criteria.getTenant() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTenant(), HouseProperty_.tenant));
            }
            if (criteria.getPropertyTax() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPropertyTax(), HouseProperty_.propertyTax));
            }
            if (criteria.getHousingLoanInterest() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHousingLoanInterest(), HouseProperty_.housingLoanInterest));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(HouseProperty_.user, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
