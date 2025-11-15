package com.codagonki.app.utils;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.codagonki.app.models.User;
import com.codagonki.app.repositories.UserRepository;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtils {
    
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    
    public User getUserFromAuthorizationHeader(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Некорректный формат токена");
        }
        
        String token = authorizationHeader.substring(7);
        
        if (!jwtTokenProvider.validateToken(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Некорректный токен");
        }
        
        Claims claims = jwtTokenProvider.getTokenClaims(token);
        Long userId = claims.get("user_id", Long.class);
        
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Пользователь не найден");
        }
        
        return userOptional.get();
    }
}