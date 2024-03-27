package com.project.escape.domain.store;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreDto {
    private String name;
    private Address address;
    private String callNumber;
    private Boolean isVisible;

    public static Store toEntity(StoreDto source) {
        return Store.builder()
                .name(source.getName())
                .address(source.getAddress())
                .callNumber(source.getCallNumber())
                .isVisible(source.getIsVisible())
                .build();
    }
}
