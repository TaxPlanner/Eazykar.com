package com.eazykar.portal.repository;

import com.eazykar.portal.domain.KeyInformation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the KeyInformation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KeyInformationRepository extends JpaRepository<KeyInformation, Long>, JpaSpecificationExecutor<KeyInformation> {

}
