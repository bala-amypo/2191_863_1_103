package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

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
        return availableDate;
    }
    public Boolean getAvailable()
    {
        return available;
    }
    //Setters
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
    public void setAvailableDate(String availableDate)
    {
        this.availableDate = availableDate;
    }
    public void setAvailable(Role available)
    {
        this.available = available;
    }
}
