package com.project.escape.global.exception;

import com.project.escape.global.common.GeneralResponseCode;
import lombok.Getter;

@Getter
public class GeneralInternalError extends GeneralException {

    public GeneralInternalError() {
        super(GeneralResponseCode.INTERNAL_ERROR);
    }
}

