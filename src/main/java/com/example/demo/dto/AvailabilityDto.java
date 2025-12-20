package com.example.demo.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityDto {
    private Boolean available;
    private LocalDate availableDate;
}