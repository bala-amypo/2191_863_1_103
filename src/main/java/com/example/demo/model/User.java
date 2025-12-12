package com.example.demo.model;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.*;

import jakarta.persistence.*;

@data
@Entity(name = "User")