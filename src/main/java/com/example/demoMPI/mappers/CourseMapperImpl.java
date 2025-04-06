package com.example.demoMPI.mappers;

import com.example.demoMPI.Course;
import com.example.demoMPI.dtos.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapperImpl implements CourseMapper {
    @Override
    public Course toCourse(CourseDTO courseDTO) {
       if(courseDTO == null)
           throw new IllegalArgumentException("Course DTO cannot be null");
       Course course = new Course();
       course.setName(courseDTO.getName());
       course.setProfessors(courseDTO.getProfessors());
       course.setStudents(courseDTO.getStudents());
       return course;
    }

    @Override
    public CourseDTO toCourseDTO(Course course) {
        if(course == null)
            throw new IllegalArgumentException("Course cannot be null");
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName(course.getName());
        courseDTO.setProfessors(course.getProfessors());
        courseDTO.setStudents(course.getStudents());
        return courseDTO;
    }
}
