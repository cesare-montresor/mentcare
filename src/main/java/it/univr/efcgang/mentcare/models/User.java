package it.univr.efcgang.mentcare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


@NoArgsConstructor

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id= 0L;

    String username;
    String password;
    String name;
    String role;

    @OneToMany(mappedBy = "mainDoctor", orphanRemoval = true, cascade = CascadeType.ALL)
    Collection<Patient> patients;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true, cascade = CascadeType.ALL)
    Collection<Prescription> prescriptions;


    public User(String username, String password, String name, String role){
        this.username=username;
        this.password=password;
        this.name=name;
        this.role=role;
    }
}
