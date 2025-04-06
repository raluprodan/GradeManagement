package com.example.demoMPI.controllers;

import com.example.demoMPI.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Grades")
@RequiredArgsConstructor
@Tag(name="Grades",description="Just Grades")
public class CourseController {
    private final CourseService courseService;

    @Operation(summary="Get all courses")
    @GetMapping("/getCourses")
    public void listCourses() {
        courseService.getAllCourses().forEach(System.out::println);
    }

    @Operation(summary="Get a students average on a course")
    @GetMapping("/getAverage")
    public void getAverage(@RequestParam long courseID,@RequestParam String registryNumber) {
        courseService.calculateAverage(courseID,registryNumber);
    }
}
