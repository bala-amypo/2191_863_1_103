package com.example.demo.model;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.*;

import jakarta.persistence.*;

@Data
@Entity(name = "User")
@Table(name = "user" , uniqueConstraints = @UniqueConstraints(columnNames = {"user_id"} , name = "user_id_unique"))
public class User implements Serializable {
    
}