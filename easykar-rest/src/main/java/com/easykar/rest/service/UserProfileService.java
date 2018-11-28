/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easykar.rest.controller.entity.UserProfile;
import com.easykar.rest.repository.UserProfileRepository;

/**
 *
 * @author manoj
 */
@Service
public class UserProfileService implements ProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    @Override
    public boolean save(UserProfile profile) {
        userProfileRepository.save(profile);
        return true;
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean updateProfile(UserProfile profile) {
        userProfileRepository.save(profile);
        return true;
        //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(Integer Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public UserProfile findByuserid(Long Id) {
        UserProfile obj = userProfileRepository.findByuserid(Id);
        return obj;
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
