package com.example.demoMPI.mappers;

import com.example.demoMPI.Student;
import com.example.demoMPI.dtos.StudentDTO;

import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {
    public StudentDTO toStudentDTO(Student student);
    public Student toStudent(StudentDTO studentDTO);
}
