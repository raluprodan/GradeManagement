package com.example.demoMPI.services;

import com.example.demoMPI.Course;
import com.example.demoMPI.dtos.CourseDTO;
import com.example.demoMPI.mappers.CourseMapper;
import com.example.demoMPI.repos.CourseRepo;
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
public class CourseService {
    private final CourseMapper courseMapper;
    private final CourseRepo courseRepo;

    public Course createCourse(CourseDTO courseDTO) {
        Course course = courseMapper.toCourse(courseDTO);
        return courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

}
