package com.codagonki.app.controllers.v1;

import com.codagonki.app.DTO.LoginRequest;
import com.codagonki.app.DTO.SignupRequest;
import com.codagonki.app.DTO.TokenResponse;
import com.codagonki.app.DTO.UserResponse;
import com.codagonki.app.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UserService userService;
    
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        UserResponse user = userService.registerUser(signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest,
                                                HttpServletResponse response) { 
        TokenResponse tokenResponse = userService.authenticateUser(loginRequest);
        
        Cookie accessTokenCookie = new Cookie("accessToken", tokenResponse.getAccessToken());
        accessTokenCookie.setHttpOnly(false);
        accessTokenCookie.setSecure(false);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge((int) TimeUnit.MINUTES.toSeconds(30)); 
        
        Cookie refreshTokenCookie = new Cookie("refreshToken", tokenResponse.getRefreshToken());
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setSecure(false);
        refreshTokenCookie.setPath("/auth/refresh"); 
        refreshTokenCookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(7)); 
        response.addCookie(accessTokenCookie);     
        response.addCookie(refreshTokenCookie);
        return ResponseEntity.ok()
            .header("alg", "HS256")
            .header("typ", "JWT")
            .body(tokenResponse);
    }
}