/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easykar.rest.model.registration.Users;
import com.easykar.rest.repository.UserRepository;

/**
 *
 * @author manoj
 */
@Service
public class DefaultUserService implements UserService {
    @Autowired
    private UserRepository userRepository;
    //    @Override
    //    public Users save(Users entity) {
    //        return userRepository.save(entity);
    //       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //    }
    //
    //    @Override
    //    public Users getById(Serializable id) {
    //      //  return userRepository.findOne((Long) id);
    //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //    }
    //
    //    @Override
    //    public List<Users> getAll() {
    //        return userRepository.findAll();
    //        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //    }
    //
    //    @Override
    //    public void delete(Serializable id) {
    //       // userRepository.delete((Long) id);
    //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //    }
    
    @Override
    public List<Users> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Users getById(long articleId) {
        Users obj = userRepository.findById(articleId).get();
        return obj;
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean save(Users entity) {
        userRepository.save(entity);
        return true;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void updateArticle(Users article) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(long articleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Users findByEmail(String email) {
        Users obj = userRepository.findByEmail(email);
        return obj;
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
