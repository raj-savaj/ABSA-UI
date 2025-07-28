package com.acc.controller.inquiry;

import com.acc.entity.UserProfile;
import com.acc.model.dto.userProfile.UserProfileDetailsDTO;
import com.acc.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @GetMapping("/{userId}")
    public List<UserProfileDetailsDTO> getUserById(@PathVariable String userId) {
        return service.getUserProfile(userId);

    }
}
