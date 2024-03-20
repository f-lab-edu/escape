package com.project.escape.domain.reservation;

import com.project.escape.domain.reservation.user.UserReservation;
import com.project.escape.domain.reservation.user.UserReservationRepository;
import com.project.escape.domain.reservation.user.UserReservationRequest;
import com.project.escape.domain.reservation.user.UserReservationStatus;
import com.project.escape.domain.user.User;
import com.project.escape.domain.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(value = "local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserReservationRepositoryTest {
    @Autowired
    private UserReservationRepository userReservationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    private static final Long USER_ID = 1L;
    private static final Long RESERVATION_ID = 1L;

    @Test
    @DisplayName("회원이 방탈출 테마를 예약하면 회원의 테마 예약 데이터가 저장된다.")
    void saveUserReservation() {
        // given
        UserReservationRequest request = new UserReservationRequest(USER_ID, RESERVATION_ID);
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        Reservation reservation = reservationRepository.findById(request.getReservationId()).orElseThrow();

        // when
        UserReservation savedUserReservation = userReservationRepository.save(new UserReservation(user, reservation));

        // then
        assertThat(savedUserReservation.getUser().getId()).isEqualTo(USER_ID);
        assertThat(savedUserReservation.getUser()).isNotNull();
        assertThat(savedUserReservation.getReservation().getId()).isEqualTo(RESERVATION_ID);
        assertThat(savedUserReservation.getReservation()).isNotNull();
        assertThat(savedUserReservation.getStatus()).isEqualTo(UserReservationStatus.WAITING);
        assertThat(savedUserReservation.getIsSuccess()).isNull();
        assertThat(savedUserReservation.getRecordTime()).isNull();
    }
}
