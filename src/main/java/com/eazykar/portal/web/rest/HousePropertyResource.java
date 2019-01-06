package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.HouseProperty;
import com.eazykar.portal.service.HousePropertyService;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import com.eazykar.portal.web.rest.util.PaginationUtil;
import com.eazykar.portal.service.dto.HousePropertyCriteria;
import com.eazykar.portal.service.HousePropertyQueryService;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing HouseProperty.
 */
@RestController
@RequestMapping("/api")
public class HousePropertyResource {

    private final Logger log = LoggerFactory.getLogger(HousePropertyResource.class);

    private static final String ENTITY_NAME = "houseProperty";

    private final HousePropertyService housePropertyService;

    private final HousePropertyQueryService housePropertyQueryService;

    public HousePropertyResource(HousePropertyService housePropertyService, HousePropertyQueryService housePropertyQueryService) {
        this.housePropertyService = housePropertyService;
        this.housePropertyQueryService = housePropertyQueryService;
    }

    /**
     * POST  /house-properties : Create a new houseProperty.
     *
     * @param houseProperty the houseProperty to create
     * @return the ResponseEntity with status 201 (Created) and with body the new houseProperty, or with status 400 (Bad Request) if the houseProperty has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/house-properties")
    @Timed
    public ResponseEntity<HouseProperty> createHouseProperty(@Valid @RequestBody HouseProperty houseProperty) throws URISyntaxException {
        log.debug("REST request to save HouseProperty : {}", houseProperty);
        if (houseProperty.getId() != null) {
            throw new BadRequestAlertException("A new houseProperty cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HouseProperty result = housePropertyService.save(houseProperty);
        return ResponseEntity.created(new URI("/api/house-properties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /house-properties : Updates an existing houseProperty.
     *
     * @param houseProperty the houseProperty to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated houseProperty,
     * or with status 400 (Bad Request) if the houseProperty is not valid,
     * or with status 500 (Internal Server Error) if the houseProperty couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/house-properties")
    @Timed
    public ResponseEntity<HouseProperty> updateHouseProperty(@Valid @RequestBody HouseProperty houseProperty) throws URISyntaxException {
        log.debug("REST request to update HouseProperty : {}", houseProperty);
        if (houseProperty.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        HouseProperty result = housePropertyService.save(houseProperty);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, houseProperty.getId().toString()))
            .body(result);
    }

    /**
     * GET  /house-properties : get all the houseProperties.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of houseProperties in body
     */
    @GetMapping("/house-properties")
    @Timed
    public ResponseEntity<List<HouseProperty>> getAllHouseProperties(HousePropertyCriteria criteria, Pageable pageable) {
        log.debug("REST request to get HouseProperties by criteria: {}", criteria);
        Page<HouseProperty> page = housePropertyQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/house-properties");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /house-properties/count : count all the houseProperties.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/house-properties/count")
    @Timed
    public ResponseEntity<Long> countHouseProperties(HousePropertyCriteria criteria) {
        log.debug("REST request to count HouseProperties by criteria: {}", criteria);
        return ResponseEntity.ok().body(housePropertyQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /house-properties/:id : get the "id" houseProperty.
     *
     * @param id the id of the houseProperty to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the houseProperty, or with status 404 (Not Found)
     */
    @GetMapping("/house-properties/{id}")
    @Timed
    public ResponseEntity<HouseProperty> getHouseProperty(@PathVariable Long id) {
        log.debug("REST request to get HouseProperty : {}", id);
        Optional<HouseProperty> houseProperty = housePropertyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(houseProperty);
    }

    /**
     * DELETE  /house-properties/:id : delete the "id" houseProperty.
     *
     * @param id the id of the houseProperty to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/house-properties/{id}")
    @Timed
    public ResponseEntity<Void> deleteHouseProperty(@PathVariable Long id) {
        log.debug("REST request to delete HouseProperty : {}", id);
        housePropertyService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
