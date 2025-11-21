package com.codagonki.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String accessTokenSecret;
    private String refreshTokenSecret;
    private long accessTokenExpiration;
    private long refreshTokenExpiration;
}