package com.codagonki.app.services;

import com.codagonki.app.DTO.Auth.LoginRequest;
import com.codagonki.app.DTO.Auth.SignupRequest;
import com.codagonki.app.DTO.Auth.TokenResponse;
import com.codagonki.app.DTO.User.UpdateProfileRequest;
import com.codagonki.app.DTO.User.UserProfileResponse;
import com.codagonki.app.DTO.User.UserResponse;
import com.codagonki.app.models.User;
import com.codagonki.app.repositories.UserRepository;
import com.codagonki.app.utils.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserResponse registerUser(SignupRequest signupRequest) {
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
        User savedUser = userRepository.save(user);
        return UserResponse.builder()
            .userId(savedUser.getId())
            .email(savedUser.getEmail())
            .role(savedUser.getRole())
            .build();
    }
    
    public TokenResponse authenticateUser(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Пользователь с таким email не существует"
            );
        }
        User user = userOptional.get();
        
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getHashedPassword())) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Неверный пароль"
            );
        }
        String access_token = jwtTokenProvider.generateAccessToken(user.getId(), user.getRole());
        String refresh_token = jwtTokenProvider.generateRefreshToken(user.getId());
        return TokenResponse.builder()
            .accessToken(access_token)
            .refreshToken(refresh_token)
            .tokenType("Bearer")
            .build();
        }
    
    public UserProfileResponse getUserInfo(User user) {
        return UserProfileResponse.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .role(user.getRole())
                .rating(user.getRating())
                .build();
    }
    
    public UserProfileResponse updateUserProfile(User user, UpdateProfileRequest updateRequest) {
        if (updateRequest.getNickname() != null && !updateRequest.getNickname().equals(user.getNickname())) {
            user.setNickname(updateRequest.getNickname());
        } 
        
        User updatedUser = userRepository.save(user);
        
        return UserProfileResponse.builder()
                .email(updatedUser.getEmail())
                .nickname(updatedUser.getNickname())
                .role(updatedUser.getRole())
                .rating(updatedUser.getRating())
                .build();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }
}