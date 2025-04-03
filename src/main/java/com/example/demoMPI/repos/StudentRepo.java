package com.example.demoMPI.repos;
import com.example.demoMPI.Student;
import com.example.demoMPI.Year;
import com.example.demoMPI.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface StudentRepo extends JpaRepository<Student, Long>{
    Optional<Student> findByEmail(String email);
    Optional<Student> findById(Long id);

    @Query("SELECT s from Student s")
    List<Student> findAllStudents();

    @Query("SELECT s from Student s where s.aClass=:c AND s.year=:year AND s.activeYear=:true")
    List<Student> findAllStudentsInAClass(Class c, Year year);

}
