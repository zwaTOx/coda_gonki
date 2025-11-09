package com.codagonki.app.services;

import com.codagonki.app.DTO.SignupRequest;
import com.codagonki.app.models.User;
import com.codagonki.app.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public User registerUser(SignupRequest signupRequest) {
        if (!signupRequest.getPassword().equals(signupRequest.getVerifyPassword())) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "Пароли не совпадают"
            );
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, 
                "Пользователь с таким email уже существует"
            );
        }
        User user = User.builder()
            .email(signupRequest.getEmail())
            .hashedPassword(passwordEncoder.encode(signupRequest.getPassword()))
            .nickname(signupRequest.getNickname())
            .role("USER")
            .build();
        return userRepository.save(user);
    }
    
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }
}