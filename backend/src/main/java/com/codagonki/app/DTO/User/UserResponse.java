package com.codagonki.app.DTO.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private long userId;
    private String email;
    private String role;
}