package com.easykar.rest.userprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileService {
    
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    public boolean save(UserProfile profile) {
        userProfileRepository.save(profile);
        return true;
    }
    
    public boolean updateProfile(UserProfile profile) {
        userProfileRepository.save(profile);
        return true;
    }
    
    public UserProfile findByUserId(Long Id) {
        return userProfileRepository.findByuserid(Id);
    }
    
}
