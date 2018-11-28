/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easykar.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easykar.rest.model.registration.Users;

/**
 *
 * @author manoj
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    //    List<Users> findDistinctByCategory(String category);
    //    List<Users> findByTitleAndCategory(String title, String category);
}
