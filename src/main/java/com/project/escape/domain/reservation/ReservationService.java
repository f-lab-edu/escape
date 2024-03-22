package com.project.escape.domain.reservation;

import com.project.escape.domain.reservation.user.UserReservation;
import com.project.escape.domain.reservation.user.UserReservationRepository;
import com.project.escape.domain.reservation.user.UserReservationRequest;
import com.project.escape.domain.reservation.user.UserReservationResponse;
import com.project.escape.domain.user.User;
import com.project.escape.domain.user.UserService;
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
    private final UserService userService;
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
    public UserReservationResponse findById(Long reservationId) {
        UserReservation userReservation = userReservationRepository.findById(reservationId)
                .orElseThrow(ResponseFactory::notFound);
        return UserReservationResponse.of(userReservation);
    }


    private boolean isExistsByReservationId(UserReservationRequest request) {
        return userReservationRepository.existsByReservationId(request.getReservationId());
    }

    private UserReservation getUserReservation(UserReservationRequest request) {
        User user = getUser(request.getUserId());
        Reservation reservation = getReservation(request.getReservationId());

        return new UserReservation(user, reservation, request.getPlayerCount());
    }

    private Reservation getReservation(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(ResponseFactory::notFound);
    }

    private User getUser(Long userId) {
        return userService.me(userId).toEntity();
    }
}
