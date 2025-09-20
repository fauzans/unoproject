package com.example.unoproject.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse {
    private String status;
    private String code;
    private String message;
    private String transactionId;
    private Object data;
}
