package com.example.demoMPI.mappers;

import com.example.demoMPI.Student;
import com.example.demoMPI.dtos.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements StudentMapper {
    @Override
    public Student toStudent(StudentDTO studentDTO) {
        if (studentDTO == null) {
            throw new IllegalArgumentException("StudentDTO cannot be null");
        }
        Student student = new Student();
        student.setRegistryNumber(studentDTO.getRegistryNumber());
        student.setActiveYear(studentDTO.isActiveYear());
        student.setYear(studentDTO.getYear());
        return student;
    }

    @Override
    public StudentDTO toStudentDTO(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setRegistryNumber(student.getRegistryNumber());
        studentDTO.setActiveYear(student.isActiveYear());
        studentDTO.setYear(student.getYear());
        return studentDTO;
    }
}

