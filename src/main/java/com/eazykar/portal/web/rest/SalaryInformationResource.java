package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.SalaryInformation;
import com.eazykar.portal.service.SalaryInformationService;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import com.eazykar.portal.web.rest.util.PaginationUtil;
import com.eazykar.portal.service.dto.SalaryInformationCriteria;
import com.eazykar.portal.service.SalaryInformationQueryService;
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
 * REST controller for managing SalaryInformation.
 */
@RestController
@RequestMapping("/api")
public class SalaryInformationResource {

    private final Logger log = LoggerFactory.getLogger(SalaryInformationResource.class);

    private static final String ENTITY_NAME = "salaryInformation";

    private final SalaryInformationService salaryInformationService;

    private final SalaryInformationQueryService salaryInformationQueryService;

    public SalaryInformationResource(SalaryInformationService salaryInformationService, SalaryInformationQueryService salaryInformationQueryService) {
        this.salaryInformationService = salaryInformationService;
        this.salaryInformationQueryService = salaryInformationQueryService;
    }

    /**
     * POST  /salary-informations : Create a new salaryInformation.
     *
     * @param salaryInformation the salaryInformation to create
     * @return the ResponseEntity with status 201 (Created) and with body the new salaryInformation, or with status 400 (Bad Request) if the salaryInformation has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/salary-informations")
    @Timed
    public ResponseEntity<SalaryInformation> createSalaryInformation(@Valid @RequestBody SalaryInformation salaryInformation) throws URISyntaxException {
        log.debug("REST request to save SalaryInformation : {}", salaryInformation);
        if (salaryInformation.getId() != null) {
            throw new BadRequestAlertException("A new salaryInformation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SalaryInformation result = salaryInformationService.save(salaryInformation);
        return ResponseEntity.created(new URI("/api/salary-informations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /salary-informations : Updates an existing salaryInformation.
     *
     * @param salaryInformation the salaryInformation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated salaryInformation,
     * or with status 400 (Bad Request) if the salaryInformation is not valid,
     * or with status 500 (Internal Server Error) if the salaryInformation couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/salary-informations")
    @Timed
    public ResponseEntity<SalaryInformation> updateSalaryInformation(@Valid @RequestBody SalaryInformation salaryInformation) throws URISyntaxException {
        log.debug("REST request to update SalaryInformation : {}", salaryInformation);
        if (salaryInformation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SalaryInformation result = salaryInformationService.save(salaryInformation);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, salaryInformation.getId().toString()))
            .body(result);
    }

    /**
     * GET  /salary-informations : get all the salaryInformations.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of salaryInformations in body
     */
    @GetMapping("/salary-informations")
    @Timed
    public ResponseEntity<List<SalaryInformation>> getAllSalaryInformations(SalaryInformationCriteria criteria, Pageable pageable) {
        log.debug("REST request to get SalaryInformations by criteria: {}", criteria);
        Page<SalaryInformation> page = salaryInformationQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/salary-informations");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /salary-informations/count : count all the salaryInformations.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/salary-informations/count")
    @Timed
    public ResponseEntity<Long> countSalaryInformations(SalaryInformationCriteria criteria) {
        log.debug("REST request to count SalaryInformations by criteria: {}", criteria);
        return ResponseEntity.ok().body(salaryInformationQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /salary-informations/:id : get the "id" salaryInformation.
     *
     * @param id the id of the salaryInformation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the salaryInformation, or with status 404 (Not Found)
     */
    @GetMapping("/salary-informations/{id}")
    @Timed
    public ResponseEntity<SalaryInformation> getSalaryInformation(@PathVariable Long id) {
        log.debug("REST request to get SalaryInformation : {}", id);
        Optional<SalaryInformation> salaryInformation = salaryInformationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(salaryInformation);
    }

    /**
     * DELETE  /salary-informations/:id : delete the "id" salaryInformation.
     *
     * @param id the id of the salaryInformation to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/salary-informations/{id}")
    @Timed
    public ResponseEntity<Void> deleteSalaryInformation(@PathVariable Long id) {
        log.debug("REST request to delete SalaryInformation : {}", id);
        salaryInformationService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
