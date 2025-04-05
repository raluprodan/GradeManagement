package com.example.demoMPI.dtos;

import com.example.demoMPI.YearOfClass;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String registryNumber;
    private YearOfClass year;
    private boolean activeYear;
}
