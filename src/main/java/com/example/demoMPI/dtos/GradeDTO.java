package com.example.demoMPI.dtos;

import com.example.demoMPI.Course;
import com.example.demoMPI.Professor;
import com.example.demoMPI.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDTO {
    private Professor assigner;
    private Student assignee;
    private Date date;
    private double grade;
    //private Course course;
}
