package com.example.demoMPI;

import com.example.demoMPI.dtos.StudentDTO;
import com.example.demoMPI.services.StudentService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Students")
@RequiredArgsConstructor
@Tag(name="Students",description="Shows all the things you can do with students")
public class StudentController {
    private final StudentService studentService;

    @Operation(summary = "Create Student")
    @PostMapping("/createStudent")
    public void createStudent(@RequestBody StudentDTO studentdto) {
        studentService.createStudent(studentdto);
    }

    @Operation(summary = "Student operations", description="Search students")
    @GetMapping("/allStudents")
    public List<Student> getAllStudents(){
        return studentService.listStudents();

    }

}