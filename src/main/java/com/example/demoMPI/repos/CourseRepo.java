package com.example.demoMPI.repos;

import com.example.demoMPI.Course;
import com.example.demoMPI.Grade;
import com.example.demoMPI.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    @Query("Select g from Course g where g.id=:id")
    Course findByID(long id);

    @Query("Select g from Grade g where g.course=:course AND g.assignee=:student")
    List<Grade> getAllGradesOfAStudent(Student student, Course course);
}
