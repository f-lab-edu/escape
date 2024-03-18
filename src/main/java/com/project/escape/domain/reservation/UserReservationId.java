package com.project.escape.domain.reservation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserReservationId implements Serializable {
    private Long userId;
    private Long reservationId;
}
