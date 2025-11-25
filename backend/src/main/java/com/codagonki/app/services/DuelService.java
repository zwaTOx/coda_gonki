package com.codagonki.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.codagonki.app.DTO.Duel.DuelResponse;
import com.codagonki.app.DTO.Duel.DuelsPaginationResponse;
import com.codagonki.app.models.Duel;
import com.codagonki.app.models.User;
import com.codagonki.app.repositories.DuelRepository;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DuelService {
    private final DuelRepository duelRepository;
    
    public DuelsPaginationResponse getUserDuelsPage(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Duel> duelsPage = duelRepository.findByHostUserIdOrConnectingUserId(userId, userId, pageable);
        List<DuelResponse> duelResponses = duelsPage.getContent()
            .stream()
            .map(DuelResponse::fromEntity)
            .collect(Collectors.toList());
        return DuelsPaginationResponse.of(
            duelResponses,
            page,
            size,
            duelsPage.getTotalPages()
        );
    }

    public DuelResponse createDuel(User user) {
        if (duelRepository.hasActiveDuel(user.getId())) {
            throw new RuntimeException("Пользователь уже находится в дуэли");
        }

        if (duelRepository.hasWaitingDuel(user.getId())) {
            throw new RuntimeException("Пользователь уже ждёт начала дуэли");
        }
        Duel newDuel = Duel.builder()
                .hostUserId(user.getId())
                .status(Duel.DuelStatus.WAITING)
                .createdAt(LocalDateTime.now())
                .build();
        Duel savedDuel = duelRepository.save(newDuel);
        return DuelResponse.fromEntity(savedDuel);
    }
    
    public DuelResponse connectToDuel(User user) {
        List<Duel> availableDuel = duelRepository.findWaitingDuels();
        if (availableDuel.isEmpty()) {
        throw new RuntimeException("Нет доступных для подключения дуэлей");
        }
        Duel duelToConnect = availableDuel.get(0);
        if (duelToConnect.getHostUserId().equals(user.getId())) {
            throw new RuntimeException("Нельзя подключиться к своей же дуэли");
        } 
        duelToConnect.setConnectingUserId(user.getId());
        duelToConnect.setStatus(Duel.DuelStatus.ACTIVE);
        duelToConnect.setStartTime(LocalDateTime.now());
        Duel updatedDuel = duelRepository.save(duelToConnect);
        return DuelResponse.fromEntity(updatedDuel);
    }

    public void disconnectFromDuel(Long duelId, User user) {
        Duel duel = duelRepository.findById(duelId)
            .orElseThrow(() -> new RuntimeException("Дуэль не найдена"));
        
        if (!duel.getHostUserId().equals(user.getId()) && 
            !user.getId().equals(duel.getConnectingUserId())) {
            throw new RuntimeException("Пользователь не участвует в этой дуэли");
        }

        if (duel.getStatus() == Duel.DuelStatus.WAITING){
            duelRepository.delete(duel);
            return;
        }

        
        if (duel.getStatus() != Duel.DuelStatus.ACTIVE) {
            throw new RuntimeException("Нельзя отключиться из неактивной дуэли");
        }
        
        duel.setStatus(Duel.DuelStatus.CANCELLED);
        duelRepository.save(duel);
    } 
}