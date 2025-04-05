package com.example.demoMPI.mappers;

import com.example.demoMPI.Professor;
import com.example.demoMPI.dtos.ProfessorDTO;
import com.example.demoMPI.dtos.StudentDTO;

public interface ProfessorMapper {
    public Professor toProfessor(ProfessorDTO professorDTO);
    public ProfessorDTO toProfessorDTO(Professor professor);
}
