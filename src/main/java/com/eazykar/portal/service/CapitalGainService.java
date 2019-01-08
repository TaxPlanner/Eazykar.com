package com.eazykar.portal.service;

import com.eazykar.portal.domain.CapitalGain;
import com.eazykar.portal.repository.CapitalGainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing CapitalGain.
 */
@Service
@Transactional
public class CapitalGainService {

    private final Logger log = LoggerFactory.getLogger(CapitalGainService.class);

    private final CapitalGainRepository capitalGainRepository;

    public CapitalGainService(CapitalGainRepository capitalGainRepository) {
        this.capitalGainRepository = capitalGainRepository;
    }

    /**
     * Save a capitalGain.
     *
     * @param capitalGain the entity to save
     * @return the persisted entity
     */
    public CapitalGain save(CapitalGain capitalGain) {
        log.debug("Request to save CapitalGain : {}", capitalGain);
        return capitalGainRepository.save(capitalGain);
    }

    /**
     * Get all the capitalGains.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<CapitalGain> findAll(Pageable pageable) {
        log.debug("Request to get all CapitalGains");
        return capitalGainRepository.findAll(pageable);
    }


    /**
     * Get one capitalGain by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<CapitalGain> findOne(Long id) {
        log.debug("Request to get CapitalGain : {}", id);
        return capitalGainRepository.findById(id);
    }

    /**
     * Delete the capitalGain by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete CapitalGain : {}", id);
        capitalGainRepository.deleteById(id);
    }
}
