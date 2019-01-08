package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.Deduction;
import com.eazykar.portal.repository.DeductionRepository;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Deduction.
 */
@RestController
@RequestMapping("/api")
public class DeductionResource {

    private final Logger log = LoggerFactory.getLogger(DeductionResource.class);

    private static final String ENTITY_NAME = "deduction";

    private final DeductionRepository deductionRepository;

    public DeductionResource(DeductionRepository deductionRepository) {
        this.deductionRepository = deductionRepository;
    }

    /**
     * POST  /deductions : Create a new deduction.
     *
     * @param deduction the deduction to create
     * @return the ResponseEntity with status 201 (Created) and with body the new deduction, or with status 400 (Bad Request) if the deduction has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/deductions")
    @Timed
    public ResponseEntity<Deduction> createDeduction(@Valid @RequestBody Deduction deduction) throws URISyntaxException {
        log.debug("REST request to save Deduction : {}", deduction);
        if (deduction.getId() != null) {
            throw new BadRequestAlertException("A new deduction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Deduction result = deductionRepository.save(deduction);
        return ResponseEntity.created(new URI("/api/deductions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /deductions : Updates an existing deduction.
     *
     * @param deduction the deduction to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated deduction,
     * or with status 400 (Bad Request) if the deduction is not valid,
     * or with status 500 (Internal Server Error) if the deduction couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/deductions")
    @Timed
    public ResponseEntity<Deduction> updateDeduction(@Valid @RequestBody Deduction deduction) throws URISyntaxException {
        log.debug("REST request to update Deduction : {}", deduction);
        if (deduction.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Deduction result = deductionRepository.save(deduction);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, deduction.getId().toString()))
            .body(result);
    }

    /**
     * GET  /deductions : get all the deductions.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of deductions in body
     */
    @GetMapping("/deductions")
    @Timed
    public List<Deduction> getAllDeductions() {
        log.debug("REST request to get all Deductions");
        return deductionRepository.findAll();
    }

    /**
     * GET  /deductions/:id : get the "id" deduction.
     *
     * @param id the id of the deduction to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the deduction, or with status 404 (Not Found)
     */
    @GetMapping("/deductions/{id}")
    @Timed
    public ResponseEntity<Deduction> getDeduction(@PathVariable Long id) {
        log.debug("REST request to get Deduction : {}", id);
        Optional<Deduction> deduction = deductionRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(deduction);
    }

    /**
     * DELETE  /deductions/:id : delete the "id" deduction.
     *
     * @param id the id of the deduction to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/deductions/{id}")
    @Timed
    public ResponseEntity<Void> deleteDeduction(@PathVariable Long id) {
        log.debug("REST request to delete Deduction : {}", id);

        deductionRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
