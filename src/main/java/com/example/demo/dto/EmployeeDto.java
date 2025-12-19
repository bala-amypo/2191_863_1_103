package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String fullName;
    private String email;
    private String role
    private String skills;
    private Integer maxWeeklyHours;
}