package com.example.demoMPI.mappers;

import com.example.demoMPI.Grade;
import com.example.demoMPI.dtos.GradeDTO;
import org.springframework.stereotype.Component;

@Component
public class GradeMapperImpl implements GradeMapper {
    @Override
    public Grade toGrade(GradeDTO gradeDTO) {
        if(gradeDTO == null) {
            throw new IllegalArgumentException("GradeDTO cannot be null!");
        }
        Grade grade = new Grade();
        grade.setGrade(gradeDTO.getGrade());
        //grade.setCourse(gradeDTO.getCourse());
        grade.setDate(gradeDTO.getDate());
        grade.setAssigner(gradeDTO.getAssigner());
        grade.setAssignee(gradeDTO.getAssignee());
        return grade;
    }

    @Override
    public GradeDTO toGradeDTO(Grade grade) {
        if(grade == null) {
            throw new IllegalArgumentException("Grade cannot be null!");
        }
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.setGrade(grade.getGrade());
        //gradeDTO.setCourse(grade.getCourse());
        gradeDTO.setDate(grade.getDate());
        gradeDTO.setAssigner(grade.getAssigner());
        gradeDTO.setAssignee(grade.getAssignee());
        return gradeDTO;
    }
}
