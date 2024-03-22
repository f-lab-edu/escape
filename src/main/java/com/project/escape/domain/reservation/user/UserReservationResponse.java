package com.project.escape.domain.reservation.user;

import com.project.escape.domain.reservation.ReservationResponse;
import com.project.escape.domain.user.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserReservationResponse {
    private ReservationResponse reservation;
    private UserResponse user;
    private UserReservationStatus status;
    private int playerCount;
    private int price;
    private Boolean isSuccess;
    private Integer recordTime;

    public static UserReservationResponse of(UserReservation request) {
        return UserReservationResponse.builder()
                .user(UserResponse.of(request.getUser()))
                .reservation(ReservationResponse.of(request.getReservation()))
                .status(request.getStatus())
                .playerCount(request.getPlayerCount())
                .price(request.calculatePrice())
                .isSuccess(request.getIsSuccess())
                .recordTime(request.getRecordTime())
                .build();
    }
}
