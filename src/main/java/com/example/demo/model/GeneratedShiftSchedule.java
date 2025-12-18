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
    private LocalDate shiftTemplate;

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
    public LocalDate shiftDate()
    {
        return shiftDate;
    }
     public LocalTime getStartTime()
    {
        return startTime; 
    }
    public LocalTime getEndTime()
    {
        return endTime;
    }
    public Department getDepartment()
    {
        return department;
    }
     public Employee getEmployee()
    {
        return employee; 
    }
    public ShiftTemplate getshiftTemplate()
    { 
        return shiftTemplate;

    }
    //Setters
    public void setId(Long id)
    {
        this.id = id;
    }
     public void setshiftTemplate(LocalDate shiftDate)
    {
        this.shiftDate = shiftDate;
    }
     public void setStartTime(LocalTime startTime)
    {
        this.startTime = startTime;
    }
    public void setEndTime(LocalTime endTime)
    {
        this.endTime = endTime;
    }
    public void setDepartment(Department department)
    {
        this.department = department;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
     public void setshiftTemplate(ShiftTemplate shiftTemplate)
    {
        this.shiftTemplate = shiftTemplate;
    }

}
