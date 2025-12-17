package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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
    public ShiftTemplate()
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
    public String gettemplateName()
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
        return role;
    }
    public String getSkills()
    {
        return skills;
    }
    public Department getDepartment()
    {
        return maxWeeklyHours;
    }
    //Setters
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setRole(Role role)
    {
        this.role = role;
    }
    public void setSkills(String skills)
    {
        this.skills = skills;
    }
    public void setMaxWeeklyHours(Integer maxWeeklyHours)
    {
        this.maxWeeklyHours = maxWeeklyHours;
    }
    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }
}
