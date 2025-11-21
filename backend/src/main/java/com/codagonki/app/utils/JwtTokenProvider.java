package com.codagonki.app.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.codagonki.app.config.JwtProperties;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    
    public JwtTokenProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }
        private SecretKey getAccessTokenSigningKey() {
            return Keys.hmacShaKeyFor(jwtProperties.getAccessTokenSecret().getBytes());
        }
        
        private SecretKey getRefreshTokenSigningKey() {
            return Keys.hmacShaKeyFor(jwtProperties.getRefreshTokenSecret().getBytes());
        }

    public String generateAccessToken(Long user_id, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtProperties.getAccessTokenExpiration());
        
        return Jwts.builder()
            .setHeaderParam("alg", "HS256") 
            .setHeaderParam("typ", "JWT")   
            .setSubject(user_id.toString()) 
            .claim("role", role)
            .claim("user_id", user_id) 
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(getAccessTokenSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    public String generateRefreshToken(Long user_id) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtProperties.getRefreshTokenExpiration());
        
        return Jwts.builder()
            .setHeaderParam("alg", "HS256") 
            .setHeaderParam("typ", "JWT")  
            .setSubject(user_id.toString())
            .claim("type", "refresh")
            .claim("user_id", user_id)
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(getRefreshTokenSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }
    public boolean validateAccessToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getAccessTokenSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Токен просрочен");
        } catch (MalformedJwtException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Неверный формат токена");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Некорректный токен");
        }
    }
    
    public boolean validateRefreshToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getRefreshTokenSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Токен просрочен");
        } catch (MalformedJwtException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Неверный формат токена");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Некорректный токен");
        }
    }

    public Claims getAccessTokenClaims(String token) {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(getAccessTokenSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Некорректный токен");
        }
    }
}