package com.project.escape.domain.reservation.user;

import lombok.Getter;

@Getter
public enum UserReservationStatus {
    WAITING, AVAILABLE, PROCESS, COMPLETE, REJECT, CANCEL
}
