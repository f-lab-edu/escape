package com.project.escape.domain.reservation;

import com.project.escape.domain.user.User;
import com.project.escape.global.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@IdClass(UserReservationId.class)
public class UserReservation extends BaseTimeEntity {
    @Id
    private Long userId;
    @Id
    private Long reservationId;
    @Column(nullable = false)
    private ReservationStatusType status = ReservationStatusType.WAITING;
    @Column
    private Boolean isSuccess;
    @Column
    private Integer recordTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    public void createReservation(Long userId, Long reservationId) {
        this.userId = userId;
        this.reservationId = reservationId;
    }
}
