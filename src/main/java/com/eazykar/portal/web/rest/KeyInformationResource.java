package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.KeyInformation;
import com.eazykar.portal.service.KeyInformationService;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import com.eazykar.portal.web.rest.util.PaginationUtil;
import com.eazykar.portal.service.dto.KeyInformationCriteria;
import com.eazykar.portal.service.KeyInformationQueryService;
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
 * REST controller for managing KeyInformation.
 */
@RestController
@RequestMapping("/api")
public class KeyInformationResource {

    private final Logger log = LoggerFactory.getLogger(KeyInformationResource.class);

    private static final String ENTITY_NAME = "keyInformation";

    private final KeyInformationService keyInformationService;

    private final KeyInformationQueryService keyInformationQueryService;

    public KeyInformationResource(KeyInformationService keyInformationService, KeyInformationQueryService keyInformationQueryService) {
        this.keyInformationService = keyInformationService;
        this.keyInformationQueryService = keyInformationQueryService;
    }

    /**
     * POST  /key-informations : Create a new keyInformation.
     *
     * @param keyInformation the keyInformation to create
     * @return the ResponseEntity with status 201 (Created) and with body the new keyInformation, or with status 400 (Bad Request) if the keyInformation has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/key-informations")
    @Timed
    public ResponseEntity<KeyInformation> createKeyInformation(@Valid @RequestBody KeyInformation keyInformation) throws URISyntaxException {
        log.debug("REST request to save KeyInformation : {}", keyInformation);
        if (keyInformation.getId() != null) {
            throw new BadRequestAlertException("A new keyInformation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        KeyInformation result = keyInformationService.save(keyInformation);
        return ResponseEntity.created(new URI("/api/key-informations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /key-informations : Updates an existing keyInformation.
     *
     * @param keyInformation the keyInformation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated keyInformation,
     * or with status 400 (Bad Request) if the keyInformation is not valid,
     * or with status 500 (Internal Server Error) if the keyInformation couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/key-informations")
    @Timed
    public ResponseEntity<KeyInformation> updateKeyInformation(@Valid @RequestBody KeyInformation keyInformation) throws URISyntaxException {
        log.debug("REST request to update KeyInformation : {}", keyInformation);
        if (keyInformation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        KeyInformation result = keyInformationService.save(keyInformation);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, keyInformation.getId().toString()))
            .body(result);
    }

    /**
     * GET  /key-informations : get all the keyInformations.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of keyInformations in body
     */
    @GetMapping("/key-informations")
    @Timed
    public ResponseEntity<List<KeyInformation>> getAllKeyInformations(KeyInformationCriteria criteria, Pageable pageable) {
        log.debug("REST request to get KeyInformations by criteria: {}", criteria);
        Page<KeyInformation> page = keyInformationQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/key-informations");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /key-informations/count : count all the keyInformations.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/key-informations/count")
    @Timed
    public ResponseEntity<Long> countKeyInformations(KeyInformationCriteria criteria) {
        log.debug("REST request to count KeyInformations by criteria: {}", criteria);
        return ResponseEntity.ok().body(keyInformationQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /key-informations/:id : get the "id" keyInformation.
     *
     * @param id the id of the keyInformation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the keyInformation, or with status 404 (Not Found)
     */
    @GetMapping("/key-informations/{id}")
    @Timed
    public ResponseEntity<KeyInformation> getKeyInformation(@PathVariable Long id) {
        log.debug("REST request to get KeyInformation : {}", id);
        Optional<KeyInformation> keyInformation = keyInformationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(keyInformation);
    }

    /**
     * DELETE  /key-informations/:id : delete the "id" keyInformation.
     *
     * @param id the id of the keyInformation to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/key-informations/{id}")
    @Timed
    public ResponseEntity<Void> deleteKeyInformation(@PathVariable Long id) {
        log.debug("REST request to delete KeyInformation : {}", id);
        keyInformationService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
