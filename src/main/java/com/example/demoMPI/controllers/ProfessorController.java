package com.example.demoMPI.controllers;

import com.example.demoMPI.Professor;
import com.example.demoMPI.Student;
import com.example.demoMPI.services.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Professors")
@RequiredArgsConstructor
@Tag(name="Professors",description="Shows all the things you can do with professors")
public class ProfessorController {
    private final ProfessorService professorService;
    @Operation(summary = "Get All Professors")
    @GetMapping("/allProfessors")
    public List<Professor> getAllStudents(){

        return professorService.getAllProfessors();
    }
}
