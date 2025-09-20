package com.example.unoproject.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PlayerResponse {
    private int id;
    private String name;
    private String position;
    private LocalDate birthday;
    private String nationality;
    private int squadNumber;
    private int joinYear;
    private int kontrakUntil;
    private Double gaji;
}
