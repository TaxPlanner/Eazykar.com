package com.easykar.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easykar.rest.model.registration.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    //    List<Users> findDistinctByCategory(String category);
    //    List<Users> findByTitleAndCategory(String title, String category);
}
