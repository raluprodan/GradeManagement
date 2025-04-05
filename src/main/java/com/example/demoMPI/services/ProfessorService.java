package com.example.demoMPI.services;


import com.example.demoMPI.Professor;
import com.example.demoMPI.mappers.ProfessorMapper;
import com.example.demoMPI.repos.ProfessorRepo;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Getter
@Setter
public class ProfessorService {
    private final ProfessorMapper professorMapper;
    private final ProfessorRepo professorRepo;
    public List<Professor> getAllProfessors() {
        return professorRepo.getAllProfessors();
    }
}
