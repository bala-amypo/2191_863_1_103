package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "departments")
public class Department{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String requiredSkills;

    @Column(nullable = false , updatable = false)
    private LocalDateTime createdAt;

    //Constructors
    public Department(){
        this.createdAt=LocalDateTime.now();
    }

    public Department(String name , String description , String requiredSkills)
    {
        this.name = name;
        this.email = email;
        this.role = role;
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
        this.createdAt = LocalDateTime.now();
    }

    //Getters
    public Long getId() 
    {
        return id;
    }
    public String getFullName()
    {
        return fullName; 
    }
    public String getEmail()
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