package com.example.demoMPI.controllers;

import com.example.demoMPI.Student;
import com.example.demoMPI.YearOfClass;
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

    @Operation(summary = "Get All Students")
    @GetMapping("/allStudents")
    public List<Student> getAllStudents(){
        return studentService.listStudents();
    }

    @Operation(summary = "Search student by email")
    @GetMapping("/studentByEmail")
    public Student getStudentByEmail(@RequestParam String email){
        return studentService.getStudentByEmail(email);
    }

    @Operation(summary = "Search student by year")
    @GetMapping("/studentInYear")
    public List<Student> getStudentsInYear(@RequestParam YearOfClass year){
        return studentService.getStudentsInYear(year);
    }

    @Operation(summary = "Search student by last name")
    @GetMapping("/studentByLastName")
    public List<Student> getStudentsByLastname(@RequestParam String lastname){
        return studentService.getStudentsByLastName(lastname);
    }

    @Operation(summary = "Search student by registry number")
    @GetMapping("/studentByRegistryNumber")
    public Student getStudentByRegistryNumber(@RequestParam String registryNumber){
        return studentService.getStudentByRegistryNumber(registryNumber);
    }



}