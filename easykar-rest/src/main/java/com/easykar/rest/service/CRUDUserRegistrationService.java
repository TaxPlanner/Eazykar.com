package com.easykar.rest.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDUserRegistrationService<E> {
    E save(E entity);
    
    E getById(Serializable id);
    
    List<E> getAll();
    
    void delete(Serializable id);
}
