package com.example.demoMPI.services;


import com.example.demoMPI.dtos.StudentDTO;
import com.example.demoMPI.mappers.StudentMapper;
import com.example.demoMPI.repos.StudentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public void createStudent(StudentDTO studentDTO) {
        studentRepo.save(studentMapper.toStudent(studentDTO));
    }
}
