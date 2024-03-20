package com.project.escape.domain.reservation;

import com.project.escape.domain.reservation.user.UserReservationRequest;
import com.project.escape.domain.reservation.user.UserReservationResponse;
import com.project.escape.global.common.GeneralDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.project.escape.global.utils.ResponseFactory.created;
import static com.project.escape.global.utils.ResponseFactory.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralDataResponse<UserReservationResponse> createUserReservation(@RequestBody UserReservationRequest request) {
        return created(reservationService.createUserReservation(request));
    }

    @GetMapping("/list/{userId}")
    public GeneralDataResponse<List<UserReservationResponse>> getUserReservations(@PathVariable Long userId) {
        return ok(reservationService.getUserReservationList(userId));
    }

    @GetMapping("/{reservationId}/{userId}")
    public GeneralDataResponse<UserReservationResponse> getUserReservationId(@PathVariable Long reservationId, @PathVariable Long userId) {
        return ok(reservationService.findByUserReservationId(reservationId, userId));
    }
}
