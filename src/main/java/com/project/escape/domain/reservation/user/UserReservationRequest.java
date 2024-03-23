package com.project.escape.domain.reservation.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReservationRequest {
    private Long userId;
    private Long reservationId;
    private int playerCount;

}
