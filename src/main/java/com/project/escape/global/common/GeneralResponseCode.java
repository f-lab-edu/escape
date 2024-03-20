package com.project.escape.global.common;

import lombok.Getter;

@Getter
public enum GeneralResponseCode {

    OK(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),

    BAD_REQUEST(40000, "Bad request"),
    VALIDATION_ERROR(40001, "Validation error"),
    RESERVED_THEME_ERROR(40002, "Already reserved theme"),

    UNAUTHORIZED(40100, "User unauthorized"),
    NOT_FOUND(40400, "Requested resource is not found"),

    INTERNAL_ERROR(50000, "Internal error"),
    DATA_ACCESS_ERROR(50001, "Data access error"),

    ;

    private final int code;
    private final String message;

    GeneralResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
