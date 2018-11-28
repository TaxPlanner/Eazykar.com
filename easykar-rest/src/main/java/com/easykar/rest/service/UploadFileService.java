/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easykar.rest.controller.entity.UploadFiles;
import com.easykar.rest.repository.FileUploadRepository;

/**
 *
 * @author manoj
 */
@Service
public class UploadFileService implements UploadFileInterface {
    @Autowired
    private FileUploadRepository fileUploadRepository;
    
    @Override
    public boolean save(UploadFiles files) {
        fileUploadRepository.save(files);
        return true;
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean updateProfile(UploadFiles files) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public UploadFiles findByUserid(Long Id) {
        UploadFiles obj = fileUploadRepository.findByUserID(Id);
        return obj;
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
