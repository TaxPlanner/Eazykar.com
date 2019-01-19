package com.eazykar.portal.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eazykar.portal.config.Constants;
import com.eazykar.portal.domain.ItrApplication;

/**
 * Spring Data  repository for the ItrApplication entity.
 */
@Repository
public interface ItrApplicationRepository extends JpaRepository<ItrApplication, Long>, JpaSpecificationExecutor<ItrApplication> {

    @Query("select itr_application from ItrApplication itr_application where itr_application.assignee.login = ?#{principal.username}")
    List<ItrApplication> findByAssigneeIsCurrentUser();

    List<ItrApplication> findAllByAssigneeNullOrAssigneeLogin(
        @NotNull @Pattern(regexp = Constants.LOGIN_REGEX) @Size(min = 1, max = 50) String assigneeLogin);

}
