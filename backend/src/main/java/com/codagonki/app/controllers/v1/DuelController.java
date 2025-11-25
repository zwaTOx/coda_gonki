package com.codagonki.app.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.codagonki.app.DTO.Duel.DuelResponse;
import com.codagonki.app.DTO.Duel.DuelsPaginationResponse;
import com.codagonki.app.dependencies.CurrentUser;
import com.codagonki.app.models.User;
import com.codagonki.app.services.DuelService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/duels")
@RequiredArgsConstructor
public class DuelController {
    private final DuelService duelService;

    @GetMapping("/my")
    public DuelsPaginationResponse getUserDuels(
            @CurrentUser User user,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return duelService.getUserDuelsPage(user.getId(), page, size);
    }
    

    @PostMapping("")
    public ResponseEntity<DuelResponse> createNewDuel(@CurrentUser User user) {
        try {
            DuelResponse duelInfo = duelService.createDuel(user);
            return ResponseEntity.ok(duelInfo);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                e.getMessage()  
            );
        }
    }

    @PostMapping("/connect")
    public ResponseEntity<DuelResponse> connectToDuel(@CurrentUser User user) {
        try {
            DuelResponse duelInfo = duelService.connectToDuel(user);
            return ResponseEntity.ok(duelInfo);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                e.getMessage()  
            );
        }
    }

    @DeleteMapping("/{duel_id}/disconnect")
    public ResponseEntity<Void> disconnectFromDuel(
            @PathVariable("duel_id") Long duelId,
            @CurrentUser User user) {
        try {
            duelService.disconnectFromDuel(duelId, user);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                e.getMessage()  
            );
        }
    }

}
