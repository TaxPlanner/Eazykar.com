/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easykar.rest.controller.entity.Documents;
import com.easykar.rest.repository.DocumentsRepository;

/**
 *
 * @author manoj
 */
@Service
public class DocumentsService implements DocumentsInterface {
    @Autowired
    private DocumentsRepository documentsRepository;
    
    @Override
    public boolean save(Documents files) {
        documentsRepository.save(files);
        return true;
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean updateDocs(Documents files) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Documents findByUserid(Long Id) {
        Documents obj = documentsRepository.findByUserID(Id);
        return obj;
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
