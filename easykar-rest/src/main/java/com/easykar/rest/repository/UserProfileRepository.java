/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.repository;

import com.easykar.rest.controller.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author manoj
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
  //  UserProfile findByUserid(long user_ID);

    public UserProfile findByuserid(Long Id);
}
