package com.example.demoMPI;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String registryNumber;
    private Year year;
    private Class aClass;
    private boolean activeYear;

    @ColumnDefault("STUDENT")
    private Role role;
}
