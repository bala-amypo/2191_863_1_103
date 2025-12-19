package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse
{
    private String message;
    private String token;
    private String email;
    private String name;
    private String role;

    public LoginResponse(String message,String token,String email,String name,String role)
    {
       this.message = message;
       
    }


    public LoginResponse(String message)
    {
        this.message=message;
    }
}