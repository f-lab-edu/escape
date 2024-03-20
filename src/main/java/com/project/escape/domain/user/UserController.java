package com.project.escape.domain.user;

import com.project.escape.global.common.GeneralDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.project.escape.global.utils.ResponseFactory.ok;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me/{id}")
    public GeneralDataResponse<UserResponse> me(@PathVariable Long id) {
        return ok(userService.me(id));
    }
}
