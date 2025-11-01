package com.codagonki.app.DTO;

import lombok.Data;

@Data
// @AllArgsConstructor
public class SignupRequest {
    // private int userId;
    private String username;
    private String password;
    public SignupRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}