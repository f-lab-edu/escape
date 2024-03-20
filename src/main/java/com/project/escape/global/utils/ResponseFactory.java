package com.project.escape.global.utils;

import com.project.escape.global.common.GeneralDataResponse;
import com.project.escape.global.common.GeneralResponse;
import com.project.escape.global.common.GeneralResponseCode;
import com.project.escape.global.exception.GeneralBadRequestException;
import com.project.escape.global.exception.GeneralException;
import com.project.escape.global.exception.GeneralInternalError;
import com.project.escape.global.exception.GeneralNotFoundException;

public class ResponseFactory {

    private ResponseFactory() {
    }

    public static GeneralResponse ok() {
        return new GeneralResponse(GeneralResponseCode.OK);
    }

    public static GeneralResponse created() {
        return new GeneralResponse(GeneralResponseCode.CREATED);
    }

    public static <T> GeneralDataResponse<T> ok(T data) {
        return new GeneralDataResponse<>(GeneralResponseCode.OK, data);
    }

    public static <T> GeneralDataResponse<T> created(T data) {
        return new GeneralDataResponse<>(GeneralResponseCode.CREATED, data);
    }

    public static GeneralException badRequest() {
        return new GeneralBadRequestException(GeneralResponseCode.NOT_FOUND);
    }

    public static GeneralException badRequest(GeneralResponseCode exceptionCode) {
        return new GeneralBadRequestException(exceptionCode);
    }

    public static GeneralException notFound() {
        return new GeneralNotFoundException();
    }

    public static GeneralException error() {
        return new GeneralInternalError();
    }
}
