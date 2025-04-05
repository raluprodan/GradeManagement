package com.example.demoMPI.repos;
import com.example.demoMPI.Student;
import com.example.demoMPI.YearOfClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long>{
    List<Student> findByFirstName(String name);
    List<Student> findByEmail(String email);
    List<Student> findByRegistryNumber(String registryNumber);
    List<Student> findByLastName(String lastName);
    List<Student> findAllByYear(YearOfClass year);

    @Query("SELECT s FROM Student s where s.role=:STUDENT")
    List<Student> getAllStudent();
    /// find all students in a certain course
    //List<Student> findAllInCourse(Course course);

}
