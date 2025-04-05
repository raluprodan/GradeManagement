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
@Table(name = "professors")
public class Professor extends User{
    @ManyToMany
    @JoinTable(
            name = "professor_courses",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
    @Enumerated(EnumType.STRING)
    private Role role= Role.valueOf("PROFESSOR");
}
