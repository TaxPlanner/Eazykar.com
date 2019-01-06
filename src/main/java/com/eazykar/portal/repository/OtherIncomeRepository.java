package com.eazykar.portal.repository;

import com.eazykar.portal.domain.OtherIncome;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the OtherIncome entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OtherIncomeRepository extends JpaRepository<OtherIncome, Long>, JpaSpecificationExecutor<OtherIncome> {

}
