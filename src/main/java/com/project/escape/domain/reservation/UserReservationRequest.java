package com.project.escape.domain.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReservationRequest {
    private Long userId;
    private Long reservationId;
}
