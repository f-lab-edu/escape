package com.project.escape.domain.theme;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PriceResponse {
    private Long id;
    private int playerCount;
    private int price;

    public static PriceResponse of(Price request) {
        return PriceResponse.builder()
                .id(request.getId())
                .playerCount(request.getPlayerCount())
                .price(request.getPrice())
                .build();
    }
}
