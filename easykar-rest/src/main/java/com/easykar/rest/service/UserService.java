/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.service;

import java.util.List;

import com.easykar.rest.model.registration.Users;

/**
 *
 * @author manoj
 */
public interface UserService {
    List<Users> getAll();
    
    Users getById(long articleId);
    
    boolean save(Users article);
    
    void updateArticle(Users article);
    
    void delete(long articleId);
    
    Users findByEmail(String email);
}
