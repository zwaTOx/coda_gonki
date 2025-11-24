package com.codagonki.app.DTO.Duel;

import lombok.Data;

@Data
public class DuelResponse {
    private Long id;
    private Long hostUserId;
    private Long connectingUserId;
    private String status;
    private String createdAt;
    private String startTime;  
}