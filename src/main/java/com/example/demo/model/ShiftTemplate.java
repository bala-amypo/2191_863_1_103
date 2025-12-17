package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "shift_templates")
public class ShiftTemplate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String templateName;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private String requiredSkills;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",nullable = false)
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
}
