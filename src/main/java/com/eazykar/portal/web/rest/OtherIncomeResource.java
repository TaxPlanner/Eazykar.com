package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.OtherIncome;
import com.eazykar.portal.service.OtherIncomeService;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import com.eazykar.portal.web.rest.util.PaginationUtil;
import com.eazykar.portal.service.dto.OtherIncomeCriteria;
import com.eazykar.portal.service.OtherIncomeQueryService;
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
 * REST controller for managing OtherIncome.
 */
@RestController
@RequestMapping("/api")
public class OtherIncomeResource {

    private final Logger log = LoggerFactory.getLogger(OtherIncomeResource.class);

    private static final String ENTITY_NAME = "otherIncome";

    private final OtherIncomeService otherIncomeService;

    private final OtherIncomeQueryService otherIncomeQueryService;

    public OtherIncomeResource(OtherIncomeService otherIncomeService, OtherIncomeQueryService otherIncomeQueryService) {
        this.otherIncomeService = otherIncomeService;
        this.otherIncomeQueryService = otherIncomeQueryService;
    }

    /**
     * POST  /other-incomes : Create a new otherIncome.
     *
     * @param otherIncome the otherIncome to create
     * @return the ResponseEntity with status 201 (Created) and with body the new otherIncome, or with status 400 (Bad Request) if the otherIncome has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/other-incomes")
    @Timed
    public ResponseEntity<OtherIncome> createOtherIncome(@Valid @RequestBody OtherIncome otherIncome) throws URISyntaxException {
        log.debug("REST request to save OtherIncome : {}", otherIncome);
        if (otherIncome.getId() != null) {
            throw new BadRequestAlertException("A new otherIncome cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OtherIncome result = otherIncomeService.save(otherIncome);
        return ResponseEntity.created(new URI("/api/other-incomes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /other-incomes : Updates an existing otherIncome.
     *
     * @param otherIncome the otherIncome to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated otherIncome,
     * or with status 400 (Bad Request) if the otherIncome is not valid,
     * or with status 500 (Internal Server Error) if the otherIncome couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/other-incomes")
    @Timed
    public ResponseEntity<OtherIncome> updateOtherIncome(@Valid @RequestBody OtherIncome otherIncome) throws URISyntaxException {
        log.debug("REST request to update OtherIncome : {}", otherIncome);
        if (otherIncome.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OtherIncome result = otherIncomeService.save(otherIncome);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, otherIncome.getId().toString()))
            .body(result);
    }

    /**
     * GET  /other-incomes : get all the otherIncomes.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of otherIncomes in body
     */
    @GetMapping("/other-incomes")
    @Timed
    public ResponseEntity<List<OtherIncome>> getAllOtherIncomes(OtherIncomeCriteria criteria, Pageable pageable) {
        log.debug("REST request to get OtherIncomes by criteria: {}", criteria);
        Page<OtherIncome> page = otherIncomeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/other-incomes");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /other-incomes/count : count all the otherIncomes.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/other-incomes/count")
    @Timed
    public ResponseEntity<Long> countOtherIncomes(OtherIncomeCriteria criteria) {
        log.debug("REST request to count OtherIncomes by criteria: {}", criteria);
        return ResponseEntity.ok().body(otherIncomeQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /other-incomes/:id : get the "id" otherIncome.
     *
     * @param id the id of the otherIncome to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the otherIncome, or with status 404 (Not Found)
     */
    @GetMapping("/other-incomes/{id}")
    @Timed
    public ResponseEntity<OtherIncome> getOtherIncome(@PathVariable Long id) {
        log.debug("REST request to get OtherIncome : {}", id);
        Optional<OtherIncome> otherIncome = otherIncomeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(otherIncome);
    }

    /**
     * DELETE  /other-incomes/:id : delete the "id" otherIncome.
     *
     * @param id the id of the otherIncome to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/other-incomes/{id}")
    @Timed
    public ResponseEntity<Void> deleteOtherIncome(@PathVariable Long id) {
        log.debug("REST request to delete OtherIncome : {}", id);
        otherIncomeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
