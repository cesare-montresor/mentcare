package it.univr.efcgang.mentcare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    User mainDoctor;

    @OneToMany
    Collection<Prescription> prescriptions;

    public Patient(String name, User mainDoctor){
        this.name = name;
        this.mainDoctor = mainDoctor;
    }
}
