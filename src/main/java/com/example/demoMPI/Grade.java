package com.example.demoMPI;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "assigner_id")
    private Professor assigner;
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private Student assignee;
    private Date date;
    private double grade;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
