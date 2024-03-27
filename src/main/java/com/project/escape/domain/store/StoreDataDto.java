package com.project.escape.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StoreDataDto {
    private List<Hit> hits = new ArrayList<>();

    @Getter
    @Setter
    @Builder
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldNameConstants
    static class Hit {
        private static final Pattern REGEX = Pattern.compile("-");
        private String storeName;
        private String location;
        private String area;
        private String address;
        private String storeTel;
        private Boolean storeIsopen;

        public static StoreDto toStoreDto(Hit request) {
            return StoreDto.builder()
                    .name(request.getStoreName())
                    .address(new Address(filterLocation(request.location), request.getAddress()))
                    .callNumber(filterStoreTel(request.getStoreTel()))
                    .isVisible(request.getStoreIsopen())
                    .build();
        }

        private static Location filterLocation(String location) {
            return Location.mapLocation(location);
        }

        private static String filterStoreTel(String storeTel) {
            return storeTel.replaceAll(REGEX.pattern(), "");
        }
    }
}
