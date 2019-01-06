package com.eazykar.portal.repository;

import com.eazykar.portal.domain.SalaryInformation;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the SalaryInformation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SalaryInformationRepository extends JpaRepository<SalaryInformation, Long>, JpaSpecificationExecutor<SalaryInformation> {

    @Query("select salary_information from SalaryInformation salary_information where salary_information.user.login = ?#{principal.username}")
    List<SalaryInformation> findByUserIsCurrentUser();

}
