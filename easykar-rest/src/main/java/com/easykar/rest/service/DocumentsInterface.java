package com.easykar.rest.service;

import com.easykar.rest.controller.entity.Documents;

public interface DocumentsInterface {
    boolean save(Documents files);
    
    boolean updateDocs(Documents files);
    
    void delete(Long Id);
    
    Documents findByUserid(Long Id);
}
