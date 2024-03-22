package com.project.escape.domain.reservation.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReservationRepository extends JpaRepository<UserReservation, Long> {
    boolean existsById(Long id);

    List<UserReservation> findByUserId(Long userId);
}
