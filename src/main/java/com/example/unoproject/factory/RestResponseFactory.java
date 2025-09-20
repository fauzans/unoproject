package com.example.unoproject.factory;

import com.example.unoproject.enums.RestEnum;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RestResponseFactory {

    public static RestResponse buildResponse(RestEnum restEnum, Object data) {
        return RestResponse.builder()
                .status(restEnum.getStatus())
                .code(restEnum.getCode())
                .message(restEnum.getMessage())
                .transactionId(java.util.UUID.randomUUID().toString())
                .data(data)
                .build();
    }

    public static RestResponse buildResponse(RestEnum restEnum) {
        return buildResponse(restEnum, null);
    }

    public static ResponseEntity<?> success(Object data) {
        return ResponseEntity.ok(buildResponse(RestEnum.SUCCESS, data));
    }

    // ✅ Tambahkan helper success tanpa data
    public static ResponseEntity<?> success() {
        return ResponseEntity.ok(buildResponse(RestEnum.SUCCESS));
    }

    public static ResponseEntity<?> error(RestEnum restEnum, String customMessage) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", restEnum.name());
        body.put("code", restEnum.getCode());
        body.put("message", customMessage != null ? customMessage : restEnum.getMessage());
        body.put("data", null);
        return ResponseEntity.status(Integer.parseInt(restEnum.getCode())).body(body);
    }
}