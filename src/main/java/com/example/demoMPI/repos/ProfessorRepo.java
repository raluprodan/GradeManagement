package com.example.demoMPI.repos;

import com.example.demoMPI.Professor;
import com.example.demoMPI.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepo  extends JpaRepository<Professor, Long> {
    @Query("select p from Professor p where p.id=:id")
    Professor findByID(long id);

    @Query("select s from Professor s")
    List<Professor> getAllProfessors();
    
}
