package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto 
{
    private String name;
    private String description;
    private String requiredSkills;
}
