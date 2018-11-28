package com.easykar.rest.service;

import com.easykar.rest.controller.entity.UploadFiles;

public interface UploadFileInterface {
    boolean save(UploadFiles files);
    
    boolean updateProfile(UploadFiles files);
    
    void delete(Long Id);
    
    UploadFiles findByUserid(Long Id);
}
