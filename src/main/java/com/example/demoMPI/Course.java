package com.example.demoMPI;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "courses")
    private List<Professor> professors;
    @ManyToMany(mappedBy = "courseList")
    private List<Student> students;
    @OneToMany(mappedBy = "course")
    private List<Grade> gradesPerStudent;
}

