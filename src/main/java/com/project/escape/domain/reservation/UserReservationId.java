package com.project.escape.domain.reservation;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserReservationId implements Serializable {
    @Id
    private Long userId;
    @Id
    private Long reservationId;
}
