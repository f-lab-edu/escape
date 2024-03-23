package com.project.escape.global.exception;

import com.project.escape.global.common.GeneralResponse;
import com.project.escape.global.common.GeneralResponseCode;

public class ExceptionResponse extends GeneralResponse {
    public ExceptionResponse(GeneralResponseCode exceptionCode) {
        super(exceptionCode);
    }
}
