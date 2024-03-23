package com.project.escape.domain.reservation;

import com.project.escape.domain.theme.ThemeResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Builder
public class ReservationResponse {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private ReservationStatus status;
    private Boolean isDeleted;
    private ThemeResponse theme;

    public static ReservationResponse of(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .date(reservation.getDate())
                .time(reservation.getTime())
                .status(reservation.getStatus())
                .isDeleted(reservation.getIsDeleted())
                .theme(ThemeResponse.of(reservation.getTheme()))
                .build();
    }
}
