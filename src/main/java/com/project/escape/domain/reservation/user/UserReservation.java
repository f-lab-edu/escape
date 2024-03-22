package com.project.escape.domain.reservation.user;

import com.project.escape.domain.reservation.Reservation;
import com.project.escape.domain.user.User;
import com.project.escape.global.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserReservation extends BaseTimeEntity {
    @Id
    @Column(name = "reservation_id")
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserReservationStatus status = UserReservationStatus.WAITING;
    @Column
    private Boolean isSuccess;
    @Column
    private Integer recordTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @MapsId
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public UserReservation(User user, Reservation reservation) {
        this.user = user;
        this.reservation = reservation;
    }
}
