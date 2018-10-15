/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.service;

import com.project.easykar.model.registration.Users;
import java.util.List;

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
