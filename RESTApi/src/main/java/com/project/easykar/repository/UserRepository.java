/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.repository;

import com.project.easykar.model.registration.Users;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author manoj
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    Users findByEmail(String email);
//    List<Users> findDistinctByCategory(String category);
//    List<Users> findByTitleAndCategory(String title, String category);
}
