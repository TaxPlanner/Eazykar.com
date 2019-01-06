package com.eazykar.portal.repository;

import com.eazykar.portal.domain.HouseProperty;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the HouseProperty entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HousePropertyRepository extends JpaRepository<HouseProperty, Long>, JpaSpecificationExecutor<HouseProperty> {

}
