package com.easykar.rest.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    //    List<Users> findDistinctByCategory(String category);
    //    List<Users> findByTitleAndCategory(String title, String category);
}
