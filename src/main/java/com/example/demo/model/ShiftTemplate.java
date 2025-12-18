package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "shift_templates")
public class ShiftTemplate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Template name is required")
    private String templateName;

    @Column(nullable = false)
    @NotBlank(message = "Start time is required")
    private LocalTime startTime;

    @Column(nullable = false)
    @NotBlank(message = "End time is required")
    private LocalTime endTime;

    @Column(nullable = false)
    @NotBlank(message = "Required skills are required")
    private String requiredSkills;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",nullable = false)
    @NotBlank(message = "Department is required")
    private Department department;

    //Constructors
    public ShiftTemplate(){
    }

    public ShiftTemplate(String templateName , LocalTime startTime , LocalTime endTime , String requiredSkills , Department department)
    {
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredSkills = requiredSkills;
        this.department = department;

    }

    //Getters
    public Long getId() 
    {
        return id;
    }
    public String getTemplateName()
    {
        return templateName;
    }
    public LocalTime getStartTime()
    {
        return startTime; 
    }
    public LocalTime getEndTime()
    {
        return endTime;
    }
    public String getRequiredSkills()
    {
        return requiredSkills;
    }
    public Department getDepartment()
    {
        return department;
    }
    //Setters
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setTemplateName(String templateName)
    {
        this.templateName = templateName;
    }
    public void setStartTime(LocalTime startTime)
    {
        this.startTime = startTime;
    }
    public void setEndTime(LocalTime endTime)
    {
        this.endTime = endTime;
    }
    public void setRequiredSkills(String requiredSkills)
    {
        this.requiredSkills = requiredSkills;
    }
    public void setDepartment(Department department)
    {
        this.department = department;
    }
    @PrePersist
    @PreUpdate
    private void validateTimes()
    {
        if(endTime != null && startTime !=null)
        {
            if(endTime.isBefore(startTime)||endTime.equals(startTime))
            {
                throw new IllegalArgumentException("End time must be after start time");
            }
        }
    }
 }

