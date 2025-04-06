package com.example.demoMPI.dtos;

import com.example.demoMPI.Professor;
import com.example.demoMPI.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private String name;
    private List<Professor> professors;
    private List<Student> students;

}
