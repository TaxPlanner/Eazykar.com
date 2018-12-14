package com.eazykar.portal.repository;

import com.eazykar.portal.domain.UserPlan;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the UserPlan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserPlanRepository extends JpaRepository<UserPlan, Long>, JpaSpecificationExecutor<UserPlan> {

}
