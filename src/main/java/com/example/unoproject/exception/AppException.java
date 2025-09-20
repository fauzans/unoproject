package com.example.unoproject.exception;

import com.example.unoproject.enums.RestEnum;

public class AppException extends RuntimeException {

    private final String code;

    public AppException(String code, String message) {
        super(message);
        this.code = code;
    }

    // Constructor pakai Enum
    public AppException(RestEnum restEnum) {
        super(restEnum.getMessage());
        this.code = restEnum.getCode();
    }

    public String getCode() {
        return code;
    }
}
