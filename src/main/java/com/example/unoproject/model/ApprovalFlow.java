package com.example.unoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalFlow {
        private int id;
        private String requestId;
        private String approver;
        private int level;
        private String status;
        private LocalDateTime createdAt;
}
