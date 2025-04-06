package com.example.demoMPI.mappers;

import com.example.demoMPI.Grade;
import com.example.demoMPI.dtos.GradeDTO;


public interface GradeMapper {
     Grade toGrade(GradeDTO gradeDTO);
     GradeDTO toGradeDTO(Grade grade);
}
