package com.project.escape.domain.reservation.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserReservationResponse {
    private Long userId;
    private Long reservationId;
    private UserReservationStatus status;

    public static UserReservationResponse of(UserReservation request) {
        return UserReservationResponse.builder()
                .userId(request.getUser().getId())
                .reservationId(request.getReservation().getId())
                .status(request.getStatus())
                .build();
    }
}
