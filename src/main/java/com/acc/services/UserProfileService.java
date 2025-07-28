package com.acc.services;

import com.acc.entity.UserProfile;
import com.acc.model.dto.userProfile.UserProfileDetailsDTO;
import com.acc.repository.UserProfileRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userRepo;

    public List<UserProfileDetailsDTO> getUserProfile(String userId) {
        List<UserProfileDetailsDTO> dto = userRepo.findUserDetailsByUserId(userId);
        if (dto.isEmpty()) {
            throw new RuntimeException("Account not found");
        }
        return dto;
    }

}
