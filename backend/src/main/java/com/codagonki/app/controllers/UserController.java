package com.codagonki.app.controllers;

import com.codagonki.app.DTO.LoginRequest;
import com.codagonki.app.DTO.SignupRequest;
import com.codagonki.app.DTO.TokenResponse;
import com.codagonki.app.DTO.UserResponse;
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
        UserResponse user = userService.registerUser(signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        TokenResponse tokenResponse = userService.authenticateUser(loginRequest);
        return ResponseEntity.ok()
            .header("alg", "HS256")
            .header("typ", "JWT")
            .body(tokenResponse);
    }

}