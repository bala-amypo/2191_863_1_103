package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_availability",uniqueConstraints = @UniqueConstraints(columnNames = {"employee_id","available_date"}))
public class EmployeeAvailability{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private LocalDate availableDate;

    @Column(nullable = false)
    private Boolean available = true;

    //Constructors
    public EmployeeAvailability(){
    }

    public EmployeeAvailability(Employee employee , Role role , LocalDate availableDate , Boolean available)
    {
        this.employee = employee;
        this.role = role;
        this.availableDate = availableDate;
        this.available = available;
    }

    //Getters
    public Long getId() 
    {
        return id;
    }
    public Employee getEmployee()
    {
        return employee; 
    }
    public LocalDate getAvailableDate()
    {
        return email;
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
    public LocalDateTime getCreatedAt()
    {
        return createdAt;
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
