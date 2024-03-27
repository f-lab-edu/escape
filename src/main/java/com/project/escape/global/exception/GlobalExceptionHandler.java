package com.project.escape.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = GeneralRuntimeException.class)
    public ExceptionResponse handlerException(GeneralRuntimeException e) {
        return new ExceptionResponse(e.getExceptionCode());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = GeneralBadRequestException.class)
    public ExceptionResponse handlerException(GeneralBadRequestException e) {
        return new ExceptionResponse(e.getExceptionCode());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = GeneralNotFoundException.class)
    public ExceptionResponse handlerException(GeneralNotFoundException e) {
        return new ExceptionResponse(e.getExceptionCode());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = GeneralInternalError.class)
    public ExceptionResponse handlerException(GeneralInternalError e) {
        return new ExceptionResponse(e.getExceptionCode());
    }
}
