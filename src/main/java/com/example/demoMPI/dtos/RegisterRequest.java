package com.example.demoMPI.dtos;

import com.example.demoMPI.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Role role;
}
