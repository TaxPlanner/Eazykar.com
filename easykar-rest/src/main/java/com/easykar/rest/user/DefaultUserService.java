package com.easykar.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<Users> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Users getById(long articleId) {
        return userRepository.findById(articleId).get();
    }
    
    public boolean save(Users entity) {
        userRepository.save(entity);
        return true;
    }
    
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
