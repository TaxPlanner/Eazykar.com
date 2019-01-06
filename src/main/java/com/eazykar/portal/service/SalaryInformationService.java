package com.eazykar.portal.service;

import com.eazykar.portal.domain.SalaryInformation;
import com.eazykar.portal.repository.SalaryInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing SalaryInformation.
 */
@Service
@Transactional
public class SalaryInformationService {

    private final Logger log = LoggerFactory.getLogger(SalaryInformationService.class);

    private final SalaryInformationRepository salaryInformationRepository;

    public SalaryInformationService(SalaryInformationRepository salaryInformationRepository) {
        this.salaryInformationRepository = salaryInformationRepository;
    }

    /**
     * Save a salaryInformation.
     *
     * @param salaryInformation the entity to save
     * @return the persisted entity
     */
    public SalaryInformation save(SalaryInformation salaryInformation) {
        log.debug("Request to save SalaryInformation : {}", salaryInformation);
        return salaryInformationRepository.save(salaryInformation);
    }

    /**
     * Get all the salaryInformations.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<SalaryInformation> findAll(Pageable pageable) {
        log.debug("Request to get all SalaryInformations");
        return salaryInformationRepository.findAll(pageable);
    }


    /**
     * Get one salaryInformation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<SalaryInformation> findOne(Long id) {
        log.debug("Request to get SalaryInformation : {}", id);
        return salaryInformationRepository.findById(id);
    }

    /**
     * Delete the salaryInformation by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete SalaryInformation : {}", id);
        salaryInformationRepository.deleteById(id);
    }
}
