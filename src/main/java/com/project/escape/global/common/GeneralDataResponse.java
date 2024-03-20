package com.project.escape.global.common;

import lombok.Getter;

@Getter
public class GeneralDataResponse<T> extends GeneralResponse {
    private final T data;

    public GeneralDataResponse(GeneralResponseCode generalResponseCode, T data) {
        super(generalResponseCode);
        this.data = data;
    }
}
