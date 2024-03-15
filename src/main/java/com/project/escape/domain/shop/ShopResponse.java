package com.project.escape.domain.shop;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShopResponse {
    private Long id;
    private String name;
    private LocationType location;
    private String address;
    private String callNumber;


    public static ShopResponse of(Shop request) {
        return ShopResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .location(request.getAddress().getLocation())
                .address(request.getAddress().getAddressDetail())
                .callNumber(request.getCallNumber())
                .build();
    }
}
