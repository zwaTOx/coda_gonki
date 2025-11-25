package com.codagonki.app.utils;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.codagonki.app.models.User;
import com.codagonki.app.repositories.UserRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtils {
    
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    
    public User getUserFromCookie(HttpServletRequest request) {
        String accessToken = getCookieValue(request, "accessToken");
        if (accessToken == null || accessToken.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access token не найден в куках");
        }
        
        if (!jwtTokenProvider.validateAccessToken(accessToken)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Некорректный access token");
        }
        
        Claims claims = jwtTokenProvider.getAccessTokenClaims(accessToken);
        Long userId = claims.get("user_id", Long.class);
        
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Пользователь не найден");
        }
        
        return userOptional.get();
    }

    private String getCookieValue(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }
        for (Cookie cookie : request.getCookies()) {
            if (cookieName.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}