package com.project.escape.domain.reservation;

import com.project.escape.domain.reservation.user.UserReservation;
import com.project.escape.domain.reservation.user.UserReservationId;
import com.project.escape.domain.reservation.user.UserReservationRepository;
import com.project.escape.domain.reservation.user.UserReservationRequest;
import com.project.escape.domain.reservation.user.UserReservationResponse;
import com.project.escape.domain.user.User;
import com.project.escape.domain.user.UserRepository;
import com.project.escape.global.common.GeneralResponseCode;
import com.project.escape.global.utils.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.project.escape.global.utils.ResponseFactory.badRequest;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final UserReservationRepository userReservationRepository;

    @Transactional
    public UserReservationResponse createUserReservation(UserReservationRequest request) {
        if (isExistsByReservationId(request)) {
            throw badRequest(GeneralResponseCode.RESERVED_THEME_ERROR);
        }
        UserReservation userReservation = userReservationRepository.save(getUserReservation(request));

        return UserReservationResponse.of(userReservation);
    }

    @Transactional(readOnly = true)
    public List<UserReservationResponse> getUserReservationList(Long userId) {
        return userReservationRepository.findByUserId(userId)
                .stream()
                .map(UserReservationResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserReservationResponse findByUserReservationId(Long reservationId, Long userId) {
        UserReservation userReservation = userReservationRepository.findById(new UserReservationId(reservationId, userId))
                .orElseThrow(ResponseFactory::notFound);
        return UserReservationResponse.of(userReservation);
    }


    private boolean isExistsByReservationId(UserReservationRequest request) {
        return userReservationRepository.existsByReservationId(request.getReservationId());
    }

    private UserReservation getUserReservation(UserReservationRequest request) {
        User user = getUser(request.getUserId());
        Reservation reservation = getReservation(request.getReservationId());

        return new UserReservation(user, reservation);
    }

    private Reservation getReservation(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(ResponseFactory::notFound);
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(ResponseFactory::notFound);
    }
}
