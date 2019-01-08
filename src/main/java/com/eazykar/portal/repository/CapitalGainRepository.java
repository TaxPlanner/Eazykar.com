package com.eazykar.portal.repository;

import com.eazykar.portal.domain.CapitalGain;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CapitalGain entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CapitalGainRepository extends JpaRepository<CapitalGain, Long>, JpaSpecificationExecutor<CapitalGain> {

}
