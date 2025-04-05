package com.example.demoMPI.repos;

import com.example.demoMPI.Professor;
import com.example.demoMPI.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepo  extends JpaRepository<Professor, Long> {
    List<Professor> getAllProfessors();
    
}
