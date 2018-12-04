package com.easykar.rest.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentsService {
    
    @Autowired
    private DocumentsRepository documentsRepository;
    
    public boolean save(Documents files) {
        documentsRepository.save(files);
        return true;
    }
    
    public Documents findByUserid(Long Id) {
        return documentsRepository.findByUserID(Id);
    }
    
}
