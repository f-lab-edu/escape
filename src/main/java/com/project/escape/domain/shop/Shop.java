package com.project.escape.domain.shop;

import com.project.escape.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Shop extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    @Embedded
    private Address address;
    @Column
    private String callNumber;
    @Column(nullable = false)
    private Boolean isVisible;
}
