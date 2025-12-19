package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftTemplateDto {
    private String templateName;
    private LocalTime startTime;
    private LocalTime role
    private String skills;
    private Integer maxWeeklyHours;
}