package com.example.unoproject.enums;

import lombok.Getter;

@Getter
public enum RestEnum {
    SUCCESS("SUCCESS", "200", "Success"),
    DATA_NOT_FOUND("FAILED", "404", "Data not found"),
    VALIDATION_ERROR("FAILED", "400", "Validation error"),
    INTERNAL_ERROR("FAILED", "500", "Internal server error");

    private final String status;
    private final String code;
    private final String message;

    RestEnum(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
