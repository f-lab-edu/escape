package com.project.escape.domain.theme;

import com.project.escape.domain.shop.ShopResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ThemeResponse {
    private Long id;
    private String name;
    private String description;
    private int duration;
    private int difficulty;
    private int horror;
    private int activity;
    private ShopResponse shop;
    private List<PriceResponse> prices;

    public static ThemeResponse of(Theme request) {
        return ThemeResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .duration(request.getDuration())
                .difficulty(request.getDifficulty())
                .horror(request.getHorror())
                .activity(request.getActivity())
                .shop(ShopResponse.of(request.getShop()))
                .prices(request.getPrices().stream().map(PriceResponse::of).toList())
                .build();
    }
}
