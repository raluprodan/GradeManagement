package com.example.demoMPI.mappers;

import com.example.demoMPI.Course;
import com.example.demoMPI.dtos.CourseDTO;

public interface CourseMapper {
    Course toCourse(CourseDTO courseDTO);
    CourseDTO toCourseDTO(Course course);
}
