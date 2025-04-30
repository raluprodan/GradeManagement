package com.example.demoMPI.controllers;

import com.example.demoMPI.User;
import com.example.demoMPI.dtos.ProfessorDTO;
import com.example.demoMPI.dtos.StudentDTO;
import com.example.demoMPI.repos.UserRepo;
import com.example.demoMPI.dtos.RegisterRequest;
import com.example.demoMPI.dtos.LoginRequest;
import com.example.demoMPI.services.JwtService;
import com.example.demoMPI.services.ProfessorService;
import com.example.demoMPI.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final StudentService studentService;
    private final ProfessorService professorService;



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use!");
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(request.getRole())
                .build();

        userRepo.save(user);

        // Automatically insert into role-specific table
        if (user.getRole().name().equals("STUDENT")) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setEmail(user.getEmail());
            studentDTO.setFirstName(user.getFirstName());
            studentDTO.setLastName(user.getLastName());
            studentDTO.setPhone(user.getPhone());
            // optionally set default year, registry number, etc.
            studentService.createStudent(studentDTO);
        } else if (user.getRole().name().equals("PROFESSOR")) {
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setEmail(user.getEmail());
            professorDTO.setFirstName(user.getFirstName());
            professorDTO.setLastName(user.getLastName());
            professorDTO.setPhone(user.getPhone());
            professorService.createProfessor(professorDTO);
        }

        return ResponseEntity.ok("User registered successfully!");
    }


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepo.findByEmail(request.getEmail()).orElseThrow();

//        return jwtService.generateToken(request.getEmail());
        // String token = jwtService.generateToken(request.getEmail());
        String token = jwtService.generateToken(user.getEmail(), user.getRole().name()); // 👈 FIXED LINE
        return Map.of(
                "token", token,
                "role", user.getRole().name());
    }

}