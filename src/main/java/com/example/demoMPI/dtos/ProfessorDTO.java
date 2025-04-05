package com.example.demoMPI.dtos;

import com.example.demoMPI.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO extends UserDTO{
    private List<Course> courses;
}
