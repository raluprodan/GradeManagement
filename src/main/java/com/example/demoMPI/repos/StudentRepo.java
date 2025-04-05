package com.example.demoMPI.repos;
import com.example.demoMPI.Student;
import com.example.demoMPI.YearOfClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long>{
   // List<Student> findByFirstNameInCourse(String name, String course);//move this to course, makes more sense

    Student findByEmail(String email);
    Student findByRegistryNumber(String registryNumber);
    List<Student> findByLastName(String lastName);
    List<Student> findAllByYearAndActiveYear(YearOfClass year, boolean activeYear);

    /// find all students in a certain course
    //List<Student> findAllInCourse(Course course);

}
