package com.project.escape.domain.reservation;

import com.project.escape.domain.reservation.user.UserReservation;
import com.project.escape.domain.reservation.user.UserReservationRepository;
import com.project.escape.domain.reservation.user.UserReservationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserReservationRepositoryTest {
    @Autowired
    private UserReservationRepository userReservationRepository;

    private static final Long USER_ID = 1L;
    private static final Long RESERVATION_ID = 1L;

    @Test
    @DisplayName("회원이 방탈출 테마를 예약하면 회원의 테마 예약 데이터가 저장된다.")
    void saveUserReservation() {
        // given
        UserReservationRequest request = new UserReservationRequest(USER_ID, RESERVATION_ID);
        UserReservation userReservation = new UserReservation();
        userReservation.createReservation(request.getUserId(), request.getReservationId());

        // when
        UserReservation savedUserReservation = userReservationRepository.save(userReservation);

        // then
        assertThat(savedUserReservation.getUserId()).isEqualTo(USER_ID);
        assertThat(savedUserReservation.getReservationId()).isEqualTo(RESERVATION_ID);
        assertThat(savedUserReservation.getStatus()).isEqualTo(ReservationStatusType.WAITING);
        assertThat(savedUserReservation.getIsSuccess()).isNull();
        assertThat(savedUserReservation.getRecordTime()).isNull();
    }
}
