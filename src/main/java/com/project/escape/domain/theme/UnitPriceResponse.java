package com.project.escape.domain.theme;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnitPriceResponse {
    private Long id;
    private int playerCount;
    private int price;

    public static UnitPriceResponse of(UnitPrice request) {
        return UnitPriceResponse.builder()
                .id(request.getId())
                .playerCount(request.getPlayerCount())
                .price(request.getPrice())
                .build();
    }
}
