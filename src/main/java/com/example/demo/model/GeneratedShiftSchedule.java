package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.LocalDate;

@Entity
@Table(name = "generatedShiftSchedule")
public class GeneratedShiftSchedule{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate = shiftDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_templates_id",nullable = false)
    private ShiftTemplate shiftTemplate;


    //Constructors
    public GeneratedShiftSchedule(){
        this.createdAt=LocalDateTime.now();
    }

    public GeneratedShiftSchedule(String fullName , String email , Role role , String skills , Integer maxWeeklyHours)
    {
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.department = department;
        this.employee = employee;
        this.shiftTemplate = shiftTemplate;
    }

    //Getters
    public Long getId() 
    {
        return id;
    }
     public LocalTime getStartTime()
    {
        return startTime; 
    }
    public LocalTime getEndTime()
    {
        return endTime;
    }
    public Role getRole()
    {
        return role;
    }
    public String getSkills()
    {
        return skills;
    }
    public Integer getMaxWeeklyHours()
    {
        return maxWeeklyHours;
    }
    public Department getDepartment()
    {
        return department;
    }
     public Employee getEmployee()
    {
        return employee; 
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
