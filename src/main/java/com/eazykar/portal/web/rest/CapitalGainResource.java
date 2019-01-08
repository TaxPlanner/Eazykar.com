package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.CapitalGain;
import com.eazykar.portal.service.CapitalGainService;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import com.eazykar.portal.web.rest.util.PaginationUtil;
import com.eazykar.portal.service.dto.CapitalGainCriteria;
import com.eazykar.portal.service.CapitalGainQueryService;
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
 * REST controller for managing CapitalGain.
 */
@RestController
@RequestMapping("/api")
public class CapitalGainResource {

    private final Logger log = LoggerFactory.getLogger(CapitalGainResource.class);

    private static final String ENTITY_NAME = "capitalGain";

    private final CapitalGainService capitalGainService;

    private final CapitalGainQueryService capitalGainQueryService;

    public CapitalGainResource(CapitalGainService capitalGainService, CapitalGainQueryService capitalGainQueryService) {
        this.capitalGainService = capitalGainService;
        this.capitalGainQueryService = capitalGainQueryService;
    }

    /**
     * POST  /capital-gains : Create a new capitalGain.
     *
     * @param capitalGain the capitalGain to create
     * @return the ResponseEntity with status 201 (Created) and with body the new capitalGain, or with status 400 (Bad Request) if the capitalGain has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/capital-gains")
    @Timed
    public ResponseEntity<CapitalGain> createCapitalGain(@Valid @RequestBody CapitalGain capitalGain) throws URISyntaxException {
        log.debug("REST request to save CapitalGain : {}", capitalGain);
        if (capitalGain.getId() != null) {
            throw new BadRequestAlertException("A new capitalGain cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CapitalGain result = capitalGainService.save(capitalGain);
        return ResponseEntity.created(new URI("/api/capital-gains/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /capital-gains : Updates an existing capitalGain.
     *
     * @param capitalGain the capitalGain to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated capitalGain,
     * or with status 400 (Bad Request) if the capitalGain is not valid,
     * or with status 500 (Internal Server Error) if the capitalGain couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/capital-gains")
    @Timed
    public ResponseEntity<CapitalGain> updateCapitalGain(@Valid @RequestBody CapitalGain capitalGain) throws URISyntaxException {
        log.debug("REST request to update CapitalGain : {}", capitalGain);
        if (capitalGain.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CapitalGain result = capitalGainService.save(capitalGain);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, capitalGain.getId().toString()))
            .body(result);
    }

    /**
     * GET  /capital-gains : get all the capitalGains.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of capitalGains in body
     */
    @GetMapping("/capital-gains")
    @Timed
    public ResponseEntity<List<CapitalGain>> getAllCapitalGains(CapitalGainCriteria criteria, Pageable pageable) {
        log.debug("REST request to get CapitalGains by criteria: {}", criteria);
        Page<CapitalGain> page = capitalGainQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/capital-gains");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /capital-gains/count : count all the capitalGains.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/capital-gains/count")
    @Timed
    public ResponseEntity<Long> countCapitalGains(CapitalGainCriteria criteria) {
        log.debug("REST request to count CapitalGains by criteria: {}", criteria);
        return ResponseEntity.ok().body(capitalGainQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /capital-gains/:id : get the "id" capitalGain.
     *
     * @param id the id of the capitalGain to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the capitalGain, or with status 404 (Not Found)
     */
    @GetMapping("/capital-gains/{id}")
    @Timed
    public ResponseEntity<CapitalGain> getCapitalGain(@PathVariable Long id) {
        log.debug("REST request to get CapitalGain : {}", id);
        Optional<CapitalGain> capitalGain = capitalGainService.findOne(id);
        return ResponseUtil.wrapOrNotFound(capitalGain);
    }

    /**
     * DELETE  /capital-gains/:id : delete the "id" capitalGain.
     *
     * @param id the id of the capitalGain to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/capital-gains/{id}")
    @Timed
    public ResponseEntity<Void> deleteCapitalGain(@PathVariable Long id) {
        log.debug("REST request to delete CapitalGain : {}", id);
        capitalGainService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
