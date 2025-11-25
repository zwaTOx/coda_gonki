package com.codagonki.app.repositories;

import com.codagonki.app.models.Duel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface DuelRepository extends JpaRepository<Duel, Long> {
    List<Duel> findByStatusOrderByCreatedAtDesc(Duel.DuelStatus status);
    
    List<Duel> findByStatus(Duel.DuelStatus status);

    List<Duel> findByHostUserId(Long hostUserId);
    
    default List<Duel> findWaitingDuels() {
        return findByStatus(Duel.DuelStatus.WAITING);
    }
    
    default List<Duel> findActiveDuels() {
        return findByStatus(Duel.DuelStatus.ACTIVE);
    }

    @NonNull
    Optional<Duel> findById(Long duelId);
    
    Page<Duel> findByHostUserIdOrConnectingUserId(Long hostUserId, Long connectingUserId, Pageable pageable);
    
    boolean existsByHostUserIdAndStatus(Long hostUserId, Duel.DuelStatus status);
    
    boolean existsByConnectingUserIdAndStatus(Long connectingUserId, Duel.DuelStatus status);

    default boolean hasActiveDuel(Long userId) {
        return existsByHostUserIdAndStatus(userId, Duel.DuelStatus.ACTIVE) ||
               existsByConnectingUserIdAndStatus(userId, Duel.DuelStatus.ACTIVE);
    }
    
    default boolean hasWaitingDuel(Long userId) {
        return existsByHostUserIdAndStatus(userId, Duel.DuelStatus.WAITING);
    }

}