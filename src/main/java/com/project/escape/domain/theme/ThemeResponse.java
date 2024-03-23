package com.project.escape.domain.theme;

import com.project.escape.domain.store.StoreResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ThemeResponse {
    private Long id;
    private String name;
    private String description;
    private int playtime;
    private ThemeInfo info;
    private StoreResponse store;
    private List<UnitPriceResponse> unitPrices;

    public static ThemeResponse of(Theme request) {
        return ThemeResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .playtime(request.getPlaytime())
                .info(request.getInfo())
                .store(StoreResponse.of(request.getStore()))
                .unitPrices(request.getUnitPrices().stream().map(UnitPriceResponse::of).toList())
                .build();
    }
}
