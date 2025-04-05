package com.example.demoMPI.dtos;

import com.example.demoMPI.YearOfClass;
import lombok.*;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends UserDTO {
    private String registryNumber;
    private YearOfClass year;
    private boolean activeYear;
}
