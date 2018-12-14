package com.eazykar.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eazykar.portal.domain.ItrApplication;

/**
 * Spring Data  repository for the ItrApplication entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ItrApplicationRepository extends JpaRepository<ItrApplication, Long>, JpaSpecificationExecutor<ItrApplication> {

    @Query("select itr_application from ItrApplication itr_application where itr_application.assignee.login = ?#{principal.username}")
    List<ItrApplication> findByAssigneeIsCurrentUser();

}
