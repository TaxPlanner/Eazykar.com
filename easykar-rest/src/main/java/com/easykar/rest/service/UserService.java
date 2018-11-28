package com.easykar.rest.service;

import java.util.List;

import com.easykar.rest.model.registration.Users;

public interface UserService {
    List<Users> getAll();
    
    Users getById(long articleId);
    
    boolean save(Users article);
    
    void updateArticle(Users article);
    
    void delete(long articleId);
    
    Users findByEmail(String email);
}
