package com.example.demoMPI.mappers;

import com.example.demoMPI.Professor;
import com.example.demoMPI.dtos.ProfessorDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapperImpl implements ProfessorMapper {
    @Override
    public Professor toProfessor(ProfessorDTO professorDTO) {
        if(professorDTO == null)
            throw new IllegalArgumentException("ProfessorDTO cannot be null");
        Professor professor = new Professor();
        professor.setCourses(professorDTO.getCourses());
        return professor;
    }

    @Override
    public ProfessorDTO toProfessorDTO(Professor professor) {
        if(professor == null)
            throw new IllegalArgumentException("Professor cannot be null");
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setCourses(professor.getCourses());
        return professorDTO;
    }
}
