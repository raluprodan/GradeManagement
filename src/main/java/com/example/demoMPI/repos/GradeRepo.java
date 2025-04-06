package com.example.demoMPI.repos;

import com.example.demoMPI.Course;
import com.example.demoMPI.Grade;
import com.example.demoMPI.Professor;
import com.example.demoMPI.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface GradeRepo extends JpaRepository<Grade, Long> {
    List<Grade> findByAssignee(Student student);
    List<Grade> findByAssigner(Professor professor);
    List<Grade> findByDate(Date date);
    List<Grade> findByCourse(Course course);

    @Query("select g from Grade g where g.id=:id")
    Grade findByID(long id);
}
