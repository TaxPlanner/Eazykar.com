package com.eazykar.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.eazykar.portal.domain.UserPlan;


/**
 * Spring Data  repository for the UserPlan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserPlanRepository extends JpaRepository<UserPlan, Long>, JpaSpecificationExecutor<UserPlan> {

}
