package it.univr.efcgang.mentcare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
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
    String roles;
    Boolean active;

    @OneToMany(mappedBy = "mainDoctor", orphanRemoval = true, cascade = CascadeType.ALL)
    Collection<Patient> patients;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true, cascade = CascadeType.ALL)
    Collection<Prescription> prescriptions;

    public User(String username, String password, String name, String roles, Boolean active ){
        this.username=username;
        this.password=password;
        this.name=name;
        this.roles=roles;
        this.active=active;
    }


    public User(String username, String password, String name, String roles) {
        this(username, password, name, roles, true);
    }



    }
