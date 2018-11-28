/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.service;

import com.easykar.rest.controller.entity.UserProfile;

/**
 *
 * @author manoj
 */
public interface ProfileService {
     boolean save(UserProfile profile);
     boolean updateProfile(UserProfile profile);
     void delete(Integer Id);
     UserProfile findByuserid(Long Id);
  //   int updateAddress(int Id,String mm);
}
