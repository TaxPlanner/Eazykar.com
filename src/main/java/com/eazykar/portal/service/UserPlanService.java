package com.eazykar.portal.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eazykar.portal.domain.UserPlan;
import com.eazykar.portal.repository.UserPlanRepository;

/**
 * Service Implementation for managing UserPlan.
 */
@Service
@Transactional
public class UserPlanService {

    private final Logger log = LoggerFactory.getLogger(UserPlanService.class);

    private final UserPlanRepository userPlanRepository;

    public UserPlanService(UserPlanRepository userPlanRepository) {
        this.userPlanRepository = userPlanRepository;
    }

    /**
     * Save a userPlan.
     *
     * @param userPlan the entity to save
     * @return the persisted entity
     */
    public UserPlan save(UserPlan userPlan) {
        log.debug("Request to save UserPlan : {}", userPlan);
        return userPlanRepository.save(userPlan);
    }

    /**
     * Get all the userPlans.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<UserPlan> findAll(Pageable pageable) {
        log.debug("Request to get all UserPlans");
        return userPlanRepository.findAll(pageable);
    }


    /**
     * Get one userPlan by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<UserPlan> findOne(Long id) {
        log.debug("Request to get UserPlan : {}", id);
        return userPlanRepository.findById(id);
    }

    /**
     * Delete the userPlan by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete UserPlan : {}", id);
        userPlanRepository.deleteById(id);
    }
}
