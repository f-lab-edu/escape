package com.project.escape.domain.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
    @Enumerated(EnumType.STRING)
    private LocationType location;
    @Column(nullable = false)
    private String addressDetail;
}
