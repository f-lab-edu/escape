package com.project.escape.domain.theme;

import com.project.escape.domain.shop.Shop;
import com.project.escape.global.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Theme extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column
    private int duration;
    @Column
    private int difficulty;
    @Column
    private int horror;
    @Column
    private int activity;
    @Column(nullable = false)
    private Boolean isVisible;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
    @OneToMany(mappedBy = "theme")
    private List<UnitPrice> unitPrices = new ArrayList<>();
}
