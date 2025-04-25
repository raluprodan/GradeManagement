package com.example.demoMPI.controllers;

import com.example.demoMPI.Grade;
import com.example.demoMPI.Professor;
import com.example.demoMPI.Student;
import com.example.demoMPI.dtos.GradeDTO;
import com.example.demoMPI.services.GradeService;
import com.example.demoMPI.services.ProfessorService;
import com.example.demoMPI.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Grades")
@RequiredArgsConstructor
@Tag(name="Grades",description="Just Grades")
public class GradeController {
    private final GradeService gradeService;
    private final StudentService studentService;
    private final ProfessorService professorService;

    @PreAuthorize("hasRole('PROFESSOR')")
    @Operation(summary = "Create a grade")
    @PostMapping("/createGrade")
    public void createGrade(@RequestParam String registryNumber, @RequestParam long professorID, @RequestParam Date date, @RequestParam double grade) {
        GradeDTO gradeDTO=new GradeDTO();
        gradeDTO.setAssignee(studentService.getStudentByRegistryNumber(registryNumber));
        gradeDTO.setAssigner(professorService.getProfessor(professorID));
        gradeDTO.setDate(date);
        gradeDTO.setGrade(grade);
        //add course id to request parameters later
        gradeService.createGrade(gradeDTO);
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @Operation(summary = "Erase a grade")
    @PostMapping("/deleteGrade")
    public void deleteGrade(@RequestParam Long gradeID) {
        Grade grade=gradeService.findGradeById(gradeID);
        gradeService.deleteGrade(grade);
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    @Operation(summary = "Update grade")
    @PostMapping("/updateGrade")
    public void updateGrade(@RequestParam double newGrade,@RequestParam long gradeId){
        Grade grade=gradeService.findGradeById(gradeId);
        gradeService.updateGrade(grade,newGrade);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @Operation(summary="Get a student's grades")
    @GetMapping("/getGrades")
    public List<Grade> getAllOfAStudentsGrades(@RequestParam String registryNumber){
        Student student=studentService.getStudentByRegistryNumber(registryNumber);
        return gradeService.getGradeRepo().findByAssignee(student);
    }

}
