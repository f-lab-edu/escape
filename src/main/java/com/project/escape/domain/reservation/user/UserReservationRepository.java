package com.project.escape.domain.reservation.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReservationRepository extends JpaRepository<UserReservation, UserReservationId> {
}
