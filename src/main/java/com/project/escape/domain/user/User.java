package com.project.escape.domain.user;

import com.project.escape.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nickname;
    @Column(unique = true)
    private String phone;
    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;
    @Column
    private String email;
    @Column
    private int level;
    @Column
    private Boolean isActivated;
}
