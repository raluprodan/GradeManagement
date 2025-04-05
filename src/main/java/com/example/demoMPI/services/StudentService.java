package com.example.demoMPI.services;


import com.example.demoMPI.Student;
import com.example.demoMPI.dtos.StudentDTO;
import com.example.demoMPI.mappers.StudentMapper;
import com.example.demoMPI.repos.StudentRepo;
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
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepo studentRepo;
    public void createStudent(StudentDTO dto) {
        Student student=studentMapper.toStudent(dto);
        System.out.println("Creating student with role: " + student.getRole());
        studentRepo.save(student);
    }
    public List<Student> listStudents() {
        return studentRepo.findAll();
    }
}

