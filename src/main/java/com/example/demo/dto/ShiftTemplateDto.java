package com.example.demo.dto;

import lombok.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftTemplateDto {
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredskills;
    private Long departmentId;
}