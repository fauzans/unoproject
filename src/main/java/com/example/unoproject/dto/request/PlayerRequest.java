package com.example.unoproject.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlayerRequest {
    private String name;
    private String position;
    private LocalDate birthday;
    private String nationality;
    private int squadNumber;
    private int joinYear;
    private int kontrakUntil;
    private Double gaji;
}
