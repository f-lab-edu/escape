package com.project.escape.global.common;

import lombok.Getter;

@Getter
public class GeneralResponse {
    private final int code;
    private final String message;

    public GeneralResponse(GeneralResponseCode generalResponseCode) {
        this(generalResponseCode.getCode(), generalResponseCode.getMessage());
    }

    public GeneralResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
