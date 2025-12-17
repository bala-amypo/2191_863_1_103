package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.ANALYST;

    public enum Role{
        ADMIN,
        ANALYST
    }

    //Constructors
    public User(){}

    public User(String name , String name , String email , String password , Role role)
    {
        
    }


}
