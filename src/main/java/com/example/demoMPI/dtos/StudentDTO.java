package com.example.demoMPI.dtos;

import com.example.demoMPI.Class;
import com.example.demoMPI.Year;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String registryNumber;
    private Year year;
    private Class aClass;
    private boolean activeYear;

}
