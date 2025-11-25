package com.codagonki.app.DTO.Duel;

import com.codagonki.app.models.Duel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DuelResponse {
    private Long id;
    private Long hostUserId;
    private Long connectingUserId;
    private String status;
    private String createdAt;
    private String startTime;
    
    public static DuelResponse fromEntity(Duel duel) {
        return new DuelResponse(
            duel.getId(),
            duel.getHostUserId(),
            duel.getConnectingUserId(),
            duel.getStatus().name(),
            duel.getCreatedAt().toString(),
            duel.getStartTime() != null ? duel.getStartTime().toString() : null
        );
    }
}