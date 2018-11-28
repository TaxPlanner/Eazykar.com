/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easykar.rest.controller.entity.UploadFiles;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadFiles, Long> {
    UploadFiles findByUserID(Long Id);
}
