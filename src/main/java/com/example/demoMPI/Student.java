package com.example.demoMPI;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends User {
    private Long id;
    private String registryNumber;
    private YearOfClass year;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courseList;
    private boolean activeYear;



    @Enumerated(EnumType.STRING) // If Role is an enum
    private Role role= Role.valueOf("STUDENT");
}
