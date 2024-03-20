package com.project.escape.global.exception;

import com.project.escape.global.common.GeneralResponseCode;
import lombok.Getter;

@Getter
public class GeneralNotFoundException extends GeneralException {

    public GeneralNotFoundException() {
        super(GeneralResponseCode.NOT_FOUND);
    }
}

