package com.eazykar.portal.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.eazykar.portal.domain.UserPlan;
import com.eazykar.portal.service.UserPlanService;
import com.eazykar.portal.web.rest.errors.BadRequestAlertException;
import com.eazykar.portal.web.rest.util.HeaderUtil;
import com.eazykar.portal.web.rest.util.PaginationUtil;
import com.eazykar.portal.service.dto.UserPlanCriteria;
import com.eazykar.portal.service.UserPlanQueryService;
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
 * REST controller for managing UserPlan.
 */
@RestController
@RequestMapping("/api")
public class UserPlanResource {

    private final Logger log = LoggerFactory.getLogger(UserPlanResource.class);

    private static final String ENTITY_NAME = "userPlan";

    private final UserPlanService userPlanService;

    private final UserPlanQueryService userPlanQueryService;

    public UserPlanResource(UserPlanService userPlanService, UserPlanQueryService userPlanQueryService) {
        this.userPlanService = userPlanService;
        this.userPlanQueryService = userPlanQueryService;
    }

    /**
     * POST  /user-plans : Create a new userPlan.
     *
     * @param userPlan the userPlan to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userPlan, or with status 400 (Bad Request) if the userPlan has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/user-plans")
    @Timed
    public ResponseEntity<UserPlan> createUserPlan(@Valid @RequestBody UserPlan userPlan) throws URISyntaxException {
        log.debug("REST request to save UserPlan : {}", userPlan);
        if (userPlan.getId() != null) {
            throw new BadRequestAlertException("A new userPlan cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserPlan result = userPlanService.save(userPlan);
        return ResponseEntity.created(new URI("/api/user-plans/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /user-plans : Updates an existing userPlan.
     *
     * @param userPlan the userPlan to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userPlan,
     * or with status 400 (Bad Request) if the userPlan is not valid,
     * or with status 500 (Internal Server Error) if the userPlan couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/user-plans")
    @Timed
    public ResponseEntity<UserPlan> updateUserPlan(@Valid @RequestBody UserPlan userPlan) throws URISyntaxException {
        log.debug("REST request to update UserPlan : {}", userPlan);
        if (userPlan.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserPlan result = userPlanService.save(userPlan);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userPlan.getId().toString()))
            .body(result);
    }

    /**
     * GET  /user-plans : get all the userPlans.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of userPlans in body
     */
    @GetMapping("/user-plans")
    @Timed
    public ResponseEntity<List<UserPlan>> getAllUserPlans(UserPlanCriteria criteria, Pageable pageable) {
        log.debug("REST request to get UserPlans by criteria: {}", criteria);
        Page<UserPlan> page = userPlanQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/user-plans");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /user-plans/count : count all the userPlans.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/user-plans/count")
    @Timed
    public ResponseEntity<Long> countUserPlans(UserPlanCriteria criteria) {
        log.debug("REST request to count UserPlans by criteria: {}", criteria);
        return ResponseEntity.ok().body(userPlanQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /user-plans/:id : get the "id" userPlan.
     *
     * @param id the id of the userPlan to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the userPlan, or with status 404 (Not Found)
     */
    @GetMapping("/user-plans/{id}")
    @Timed
    public ResponseEntity<UserPlan> getUserPlan(@PathVariable Long id) {
        log.debug("REST request to get UserPlan : {}", id);
        Optional<UserPlan> userPlan = userPlanService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userPlan);
    }

    /**
     * DELETE  /user-plans/:id : delete the "id" userPlan.
     *
     * @param id the id of the userPlan to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/user-plans/{id}")
    @Timed
    public ResponseEntity<Void> deleteUserPlan(@PathVariable Long id) {
        log.debug("REST request to delete UserPlan : {}", id);
        userPlanService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
