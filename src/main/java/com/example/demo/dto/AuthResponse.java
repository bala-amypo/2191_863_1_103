package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String message;
    private String token;
    private String email;
    private String name;
    private String role;

    public AuthResponse(String message)
{
    this.message=message;
}
}