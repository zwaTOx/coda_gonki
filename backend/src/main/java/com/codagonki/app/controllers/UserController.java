package com.codagonki.app.controllers;

import com.codagonki.app.DTO.SignupRequest;
import com.codagonki.app.models.User;
import com.codagonki.app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        User user = userService.registerUser(signupRequest);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Пользователь успешно зарегистрирован");
        response.put("userId", user.getId());
        response.put("email", user.getEmail());
        response.put("nickname", user.getNickname());
        response.put("role", user.getRole());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}