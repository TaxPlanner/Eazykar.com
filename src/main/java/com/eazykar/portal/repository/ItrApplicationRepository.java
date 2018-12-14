package com.eazykar.portal.repository;

import com.eazykar.portal.domain.ItrApplication;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ItrApplication entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ItrApplicationRepository extends JpaRepository<ItrApplication, Long>, JpaSpecificationExecutor<ItrApplication> {

}
