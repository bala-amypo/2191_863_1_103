package com.example.demo.dto;

import lombok.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftTemplateDto {
    private SLocalDate shiftDate;
    private LocalTime startTime ;
    private LocalTime endTime;
    private Department department;
    private Employee employee;
    private ShiftTemplate shiftTemplate;
}