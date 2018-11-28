package com.easykar.rest.service;

import com.easykar.rest.controller.entity.UserProfile;

public interface ProfileService {
    boolean save(UserProfile profile);
    
    boolean updateProfile(UserProfile profile);
    
    void delete(Integer Id);
    
    UserProfile findByuserid(Long Id);
    //   int updateAddress(int Id,String mm);
}
