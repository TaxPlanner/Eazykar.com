package com.eazykar.portal.service;

import com.eazykar.portal.domain.HouseProperty;
import com.eazykar.portal.repository.HousePropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing HouseProperty.
 */
@Service
@Transactional
public class HousePropertyService {

    private final Logger log = LoggerFactory.getLogger(HousePropertyService.class);

    private final HousePropertyRepository housePropertyRepository;

    public HousePropertyService(HousePropertyRepository housePropertyRepository) {
        this.housePropertyRepository = housePropertyRepository;
    }

    /**
     * Save a houseProperty.
     *
     * @param houseProperty the entity to save
     * @return the persisted entity
     */
    public HouseProperty save(HouseProperty houseProperty) {
        log.debug("Request to save HouseProperty : {}", houseProperty);
        return housePropertyRepository.save(houseProperty);
    }

    /**
     * Get all the houseProperties.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<HouseProperty> findAll(Pageable pageable) {
        log.debug("Request to get all HouseProperties");
        return housePropertyRepository.findAll(pageable);
    }


    /**
     * Get one houseProperty by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<HouseProperty> findOne(Long id) {
        log.debug("Request to get HouseProperty : {}", id);
        return housePropertyRepository.findById(id);
    }

    /**
     * Delete the houseProperty by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete HouseProperty : {}", id);
        housePropertyRepository.deleteById(id);
    }
}
