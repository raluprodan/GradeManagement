package com.example.demoMPI.services;

import com.example.demoMPI.Grade;
import com.example.demoMPI.Student;
import com.example.demoMPI.dtos.GradeDTO;
import com.example.demoMPI.mappers.GradeMapper;
import com.example.demoMPI.repos.GradeRepo;
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
public class GradeService {
    private final GradeMapper gradeMapper;
    private final GradeRepo gradeRepo;
    private final StudentService studentRepo;
    public List<Grade> findAllGradesOfStudent(Student student) {
        return gradeRepo.findByAssignee(student);
    }
    public void createGrade(GradeDTO gradeDTO) {
        Grade grade=gradeMapper.toGrade(gradeDTO);
    }
}
