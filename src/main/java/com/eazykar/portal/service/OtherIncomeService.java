package com.eazykar.portal.service;

import com.eazykar.portal.domain.OtherIncome;
import com.eazykar.portal.repository.OtherIncomeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing OtherIncome.
 */
@Service
@Transactional
public class OtherIncomeService {

    private final Logger log = LoggerFactory.getLogger(OtherIncomeService.class);

    private final OtherIncomeRepository otherIncomeRepository;

    public OtherIncomeService(OtherIncomeRepository otherIncomeRepository) {
        this.otherIncomeRepository = otherIncomeRepository;
    }

    /**
     * Save a otherIncome.
     *
     * @param otherIncome the entity to save
     * @return the persisted entity
     */
    public OtherIncome save(OtherIncome otherIncome) {
        log.debug("Request to save OtherIncome : {}", otherIncome);
        return otherIncomeRepository.save(otherIncome);
    }

    /**
     * Get all the otherIncomes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<OtherIncome> findAll(Pageable pageable) {
        log.debug("Request to get all OtherIncomes");
        return otherIncomeRepository.findAll(pageable);
    }


    /**
     * Get one otherIncome by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<OtherIncome> findOne(Long id) {
        log.debug("Request to get OtherIncome : {}", id);
        return otherIncomeRepository.findById(id);
    }

    /**
     * Delete the otherIncome by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OtherIncome : {}", id);
        otherIncomeRepository.deleteById(id);
    }
}
