package com.project.escape.global.exception;

import com.project.escape.global.common.GeneralResponseCode;
import lombok.Getter;

@Getter
public class GeneralRuntimeException extends RuntimeException {
    private final GeneralResponseCode exceptionCode;

    public GeneralRuntimeException(String message) {
        super(message);
        this.exceptionCode = GeneralResponseCode.DATA_ACCESS_ERROR;
    }
}
