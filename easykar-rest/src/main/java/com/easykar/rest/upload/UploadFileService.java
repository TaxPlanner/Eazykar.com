package com.easykar.rest.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileService {
    
    @Autowired
    private FileUploadRepository fileUploadRepository;
    
    public boolean save(UploadFiles files) {
        fileUploadRepository.save(files);
        return true;
    }
    
    public UploadFiles findByUserid(Long Id) {
        return fileUploadRepository.findByUserID(Id);
    }
    
}
