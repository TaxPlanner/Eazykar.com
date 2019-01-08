package com.eazykar.portal.repository;

import com.eazykar.portal.domain.Deduction;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Deduction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DeductionRepository extends JpaRepository<Deduction, Long> {

}
