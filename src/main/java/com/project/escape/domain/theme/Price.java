package com.project.escape.domain.theme;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int playerCount;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private Boolean isVisible;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    private Theme theme;
}
