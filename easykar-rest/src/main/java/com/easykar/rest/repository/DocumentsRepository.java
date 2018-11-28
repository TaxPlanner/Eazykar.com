package com.easykar.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easykar.rest.controller.entity.Documents;

@Repository
public interface DocumentsRepository extends JpaRepository<Documents, Long> {
    Documents findByUserID(Long Id);
}
