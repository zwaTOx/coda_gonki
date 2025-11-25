package com.codagonki.app.DTO.Duel;

import java.util.List;

import lombok.Data;

@Data
public class DuelsPaginationResponse {
    private List<DuelResponse> duels;
    private int page;
    private int size;
    private int totalPages;
    private boolean hasNext;
    private boolean hasPrevious;
    
    public DuelsPaginationResponse(List<DuelResponse> duels, int page, int size, 
                                 int totalPages, boolean hasNext, boolean hasPrevious) {
        this.duels = duels;
        this.page = page;
        this.size = size;
        this.totalPages = totalPages;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }
    
    public static DuelsPaginationResponse of(List<DuelResponse> duels, int page, int size,
                                           int totalPages) {
        return new DuelsPaginationResponse(
            duels,
            page,
            size,
            totalPages,
            page < totalPages - 1,  
            page > 0               
        );
    }
}