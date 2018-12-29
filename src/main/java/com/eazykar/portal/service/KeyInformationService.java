package com.eazykar.portal.service;

import com.eazykar.portal.domain.KeyInformation;
import com.eazykar.portal.repository.KeyInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing KeyInformation.
 */
@Service
@Transactional
public class KeyInformationService {

    private final Logger log = LoggerFactory.getLogger(KeyInformationService.class);

    private final KeyInformationRepository keyInformationRepository;

    public KeyInformationService(KeyInformationRepository keyInformationRepository) {
        this.keyInformationRepository = keyInformationRepository;
    }

    /**
     * Save a keyInformation.
     *
     * @param keyInformation the entity to save
     * @return the persisted entity
     */
    public KeyInformation save(KeyInformation keyInformation) {
        log.debug("Request to save KeyInformation : {}", keyInformation);
        return keyInformationRepository.save(keyInformation);
    }

    /**
     * Get all the keyInformations.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<KeyInformation> findAll(Pageable pageable) {
        log.debug("Request to get all KeyInformations");
        return keyInformationRepository.findAll(pageable);
    }


    /**
     * Get one keyInformation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<KeyInformation> findOne(Long id) {
        log.debug("Request to get KeyInformation : {}", id);
        return keyInformationRepository.findById(id);
    }

    /**
     * Delete the keyInformation by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete KeyInformation : {}", id);
        keyInformationRepository.deleteById(id);
    }
}
