package com.project.escape.domain.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String nickname;
    private String phone;
    private SocialType socialType;
    private String email;
    private int level;
    private Boolean isActivated;

    public static UserResponse of(User request) {
        return UserResponse.builder()
                .id(request.getId())
                .nickname(request.getNickname())
                .phone(request.getPhone())
                .socialType(request.getSocialType())
                .email(request.getEmail())
                .level(request.getLevel())
                .isActivated(request.getIsActivated())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .nickname(nickname)
                .phone(phone)
                .socialType(socialType)
                .email(email)
                .level(level)
                .isActivated(isActivated)
                .build();
    }
}
