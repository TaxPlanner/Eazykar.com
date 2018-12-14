package com.eazykar.portal.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eazykar.portal.domain.ItrApplication;
import com.eazykar.portal.repository.ItrApplicationRepository;

/**
 * Service Implementation for managing ItrApplication.
 */
@Service
@Transactional
public class ItrApplicationService {

    private final Logger log = LoggerFactory.getLogger(ItrApplicationService.class);

    private final ItrApplicationRepository itrApplicationRepository;

    public ItrApplicationService(ItrApplicationRepository itrApplicationRepository) {
        this.itrApplicationRepository = itrApplicationRepository;
    }

    /**
     * Save a itrApplication.
     *
     * @param itrApplication the entity to save
     * @return the persisted entity
     */
    public ItrApplication save(ItrApplication itrApplication) {
        log.debug("Request to save ItrApplication : {}", itrApplication);
        return itrApplicationRepository.save(itrApplication);
    }

    /**
     * Get all the itrApplications.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ItrApplication> findAll(Pageable pageable) {
        log.debug("Request to get all ItrApplications");
        return itrApplicationRepository.findAll(pageable);
    }


    /**
     * Get one itrApplication by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<ItrApplication> findOne(Long id) {
        log.debug("Request to get ItrApplication : {}", id);
        return itrApplicationRepository.findById(id);
    }

    /**
     * Delete the itrApplication by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete ItrApplication : {}", id);
        itrApplicationRepository.deleteById(id);
    }
}
