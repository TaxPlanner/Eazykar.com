/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.service;

import com.project.easykar.controller.entity.Documents;

/**
 *
 * @author manoj
 */
public interface DocumentsInterface {
    boolean save(Documents files);
     boolean updateDocs(Documents files);
     void delete(Long Id);
     Documents findByUserid(Long Id);
}