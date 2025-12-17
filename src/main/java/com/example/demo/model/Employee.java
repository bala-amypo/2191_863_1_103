package com.example.demo.model;

import jakarta.persistance.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.STAFF;

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private Integer maxWeeklyHours;

    @Column(nullable = false , updateable = false)
    private LocalDateTime createdAt;

    public enum Role {
        ADMIN,
        STAFF
    }

    //Constructors
    public Employees(){
        this.createdAt=LocalDateTime.now();
    }

    public Employees(String fullName , String email , Role role , String skills , Integer maxWeeklyHours)
    {
        this.fullName = fullName;
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
        return fullName 
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
    




}
