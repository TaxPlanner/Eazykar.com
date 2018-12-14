package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.UserProfile;
import com.eazykar.portal.service.UserProfileService;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import com.eazykar.portal.web.rest.util.PaginationUtil;
import com.eazykar.portal.service.dto.UserProfileCriteria;
import com.eazykar.portal.service.UserProfileQueryService;
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
 * REST controller for managing UserProfile.
 */
@RestController
@RequestMapping("/api")
public class UserProfileResource {

    private final Logger log = LoggerFactory.getLogger(UserProfileResource.class);

    private static final String ENTITY_NAME = "userProfile";

    private final UserProfileService userProfileService;

    private final UserProfileQueryService userProfileQueryService;

    public UserProfileResource(UserProfileService userProfileService, UserProfileQueryService userProfileQueryService) {
        this.userProfileService = userProfileService;
        this.userProfileQueryService = userProfileQueryService;
    }

    /**
     * POST  /user-profiles : Create a new userProfile.
     *
     * @param userProfile the userProfile to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userProfile, or with status 400 (Bad Request) if the userProfile has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/user-profiles")
    @Timed
    public ResponseEntity<UserProfile> createUserProfile(@Valid @RequestBody UserProfile userProfile) throws URISyntaxException {
        log.debug("REST request to save UserProfile : {}", userProfile);
        if (userProfile.getId() != null) {
            throw new BadRequestAlertException("A new userProfile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserProfile result = userProfileService.save(userProfile);
        return ResponseEntity.created(new URI("/api/user-profiles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /user-profiles : Updates an existing userProfile.
     *
     * @param userProfile the userProfile to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userProfile,
     * or with status 400 (Bad Request) if the userProfile is not valid,
     * or with status 500 (Internal Server Error) if the userProfile couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/user-profiles")
    @Timed
    public ResponseEntity<UserProfile> updateUserProfile(@Valid @RequestBody UserProfile userProfile) throws URISyntaxException {
        log.debug("REST request to update UserProfile : {}", userProfile);
        if (userProfile.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserProfile result = userProfileService.save(userProfile);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userProfile.getId().toString()))
            .body(result);
    }

    /**
     * GET  /user-profiles : get all the userProfiles.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of userProfiles in body
     */
    @GetMapping("/user-profiles")
    @Timed
    public ResponseEntity<List<UserProfile>> getAllUserProfiles(UserProfileCriteria criteria, Pageable pageable) {
        log.debug("REST request to get UserProfiles by criteria: {}", criteria);
        Page<UserProfile> page = userProfileQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/user-profiles");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /user-profiles/count : count all the userProfiles.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/user-profiles/count")
    @Timed
    public ResponseEntity<Long> countUserProfiles(UserProfileCriteria criteria) {
        log.debug("REST request to count UserProfiles by criteria: {}", criteria);
        return ResponseEntity.ok().body(userProfileQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /user-profiles/:id : get the "id" userProfile.
     *
     * @param id the id of the userProfile to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the userProfile, or with status 404 (Not Found)
     */
    @GetMapping("/user-profiles/{id}")
    @Timed
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long id) {
        log.debug("REST request to get UserProfile : {}", id);
        Optional<UserProfile> userProfile = userProfileService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userProfile);
    }

    /**
     * DELETE  /user-profiles/:id : delete the "id" userProfile.
     *
     * @param id the id of the userProfile to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/user-profiles/{id}")
    @Timed
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
        log.debug("REST request to delete UserProfile : {}", id);
        userProfileService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
