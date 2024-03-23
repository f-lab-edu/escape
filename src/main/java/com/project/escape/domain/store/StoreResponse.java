package com.project.escape.domain.store;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreResponse {
    private Long id;
    private String name;
    private Address address;
    private String callNumber;


    public static StoreResponse of(Store request) {
        return StoreResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .address(request.getAddress())
                .callNumber(request.getCallNumber())
                .build();
    }
}
