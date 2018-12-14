package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.ItrApplication;
import com.eazykar.portal.service.ItrApplicationService;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import com.eazykar.portal.web.rest.util.PaginationUtil;
import com.eazykar.portal.service.dto.ItrApplicationCriteria;
import com.eazykar.portal.service.ItrApplicationQueryService;
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
 * REST controller for managing ItrApplication.
 */
@RestController
@RequestMapping("/api")
public class ItrApplicationResource {

    private final Logger log = LoggerFactory.getLogger(ItrApplicationResource.class);

    private static final String ENTITY_NAME = "itrApplication";

    private final ItrApplicationService itrApplicationService;

    private final ItrApplicationQueryService itrApplicationQueryService;

    public ItrApplicationResource(ItrApplicationService itrApplicationService, ItrApplicationQueryService itrApplicationQueryService) {
        this.itrApplicationService = itrApplicationService;
        this.itrApplicationQueryService = itrApplicationQueryService;
    }

    /**
     * POST  /itr-applications : Create a new itrApplication.
     *
     * @param itrApplication the itrApplication to create
     * @return the ResponseEntity with status 201 (Created) and with body the new itrApplication, or with status 400 (Bad Request) if the itrApplication has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/itr-applications")
    @Timed
    public ResponseEntity<ItrApplication> createItrApplication(@Valid @RequestBody ItrApplication itrApplication) throws URISyntaxException {
        log.debug("REST request to save ItrApplication : {}", itrApplication);
        if (itrApplication.getId() != null) {
            throw new BadRequestAlertException("A new itrApplication cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ItrApplication result = itrApplicationService.save(itrApplication);
        return ResponseEntity.created(new URI("/api/itr-applications/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /itr-applications : Updates an existing itrApplication.
     *
     * @param itrApplication the itrApplication to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated itrApplication,
     * or with status 400 (Bad Request) if the itrApplication is not valid,
     * or with status 500 (Internal Server Error) if the itrApplication couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/itr-applications")
    @Timed
    public ResponseEntity<ItrApplication> updateItrApplication(@Valid @RequestBody ItrApplication itrApplication) throws URISyntaxException {
        log.debug("REST request to update ItrApplication : {}", itrApplication);
        if (itrApplication.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ItrApplication result = itrApplicationService.save(itrApplication);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, itrApplication.getId().toString()))
            .body(result);
    }

    /**
     * GET  /itr-applications : get all the itrApplications.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of itrApplications in body
     */
    @GetMapping("/itr-applications")
    @Timed
    public ResponseEntity<List<ItrApplication>> getAllItrApplications(ItrApplicationCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ItrApplications by criteria: {}", criteria);
        Page<ItrApplication> page = itrApplicationQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/itr-applications");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /itr-applications/count : count all the itrApplications.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/itr-applications/count")
    @Timed
    public ResponseEntity<Long> countItrApplications(ItrApplicationCriteria criteria) {
        log.debug("REST request to count ItrApplications by criteria: {}", criteria);
        return ResponseEntity.ok().body(itrApplicationQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /itr-applications/:id : get the "id" itrApplication.
     *
     * @param id the id of the itrApplication to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the itrApplication, or with status 404 (Not Found)
     */
    @GetMapping("/itr-applications/{id}")
    @Timed
    public ResponseEntity<ItrApplication> getItrApplication(@PathVariable Long id) {
        log.debug("REST request to get ItrApplication : {}", id);
        Optional<ItrApplication> itrApplication = itrApplicationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(itrApplication);
    }

    /**
     * DELETE  /itr-applications/:id : delete the "id" itrApplication.
     *
     * @param id the id of the itrApplication to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/itr-applications/{id}")
    @Timed
    public ResponseEntity<Void> deleteItrApplication(@PathVariable Long id) {
        log.debug("REST request to delete ItrApplication : {}", id);
        itrApplicationService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
