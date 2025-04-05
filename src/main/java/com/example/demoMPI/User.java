package com.example.demoMPI;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
@Entity
public class User {


    ///pupici dulci de la mine, ca am stat 2 ore
    /// doar sa realizeze ca nu se crea tabelul de utilizatori
    /// pt ca incercam sa ma conecteze la baza de date gresita
    /// am pus corect 2 story points in tabelul ala in jira
    /// self fulfilling prophecy much?
    /// -Ana
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}