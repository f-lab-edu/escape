package com.project.escape.domain.theme;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UnitPriceResponse {
    private int playerCount;
    private int price;

    public static UnitPriceResponse of(UnitPrice request) {
        return UnitPriceResponse.builder()
                .playerCount(request.getPlayerCount())
                .price(request.getPrice())
                .build();
    }
}
