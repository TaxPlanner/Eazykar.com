/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.repository;

import com.project.easykar.controller.entity.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author manoj
 */
@Repository
public interface DocumentsRepository extends JpaRepository<Documents, Long> {
    public Documents findByUserID(Long Id);
}