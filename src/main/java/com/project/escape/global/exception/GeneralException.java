package com.project.escape.global.exception;

import com.project.escape.global.common.GeneralResponseCode;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {
    private final GeneralResponseCode exceptionCode;

    public GeneralException(GeneralResponseCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
