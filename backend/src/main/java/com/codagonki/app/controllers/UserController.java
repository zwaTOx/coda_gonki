package com.codagonki.app.controllers;

import com.codagonki.app.DTO.SignupRequest;
import com.codagonki.app.DTO.UserResponse;
import com.codagonki.app.models.User;
import com.codagonki.app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        User user = userService.registerUser(signupRequest);
        
        UserResponse response = UserResponse.builder()
            .userId(user.getId())
            .email(user.getEmail())
            .role(user.getRole())
            .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}