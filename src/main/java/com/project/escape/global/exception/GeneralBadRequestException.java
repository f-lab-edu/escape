package com.project.escape.global.exception;

import com.project.escape.global.common.GeneralResponseCode;
import lombok.Getter;

@Getter
public class GeneralBadRequestException extends GeneralException {

    public GeneralBadRequestException(GeneralResponseCode exceptionCode) {
        super(exceptionCode);
    }
}
