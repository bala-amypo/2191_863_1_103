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

    @Column

}
