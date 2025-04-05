package com.example.demoMPI.mappers;

import com.example.demoMPI.Student;
import com.example.demoMPI.dtos.StudentDTO;

import org.springframework.stereotype.Component;

public interface StudentMapper {
    public Student toStudent(StudentDTO studentDTO);
    public StudentDTO toStudentDTO(Student student);
    // <dependency>
//			<groupId>org.springframework.boot</groupId>
//			<artifactId>spring-boot-starter-security</artifactId>
    //		</dependency>
}
