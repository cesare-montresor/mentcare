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
public class Drug {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    String name;

    @OneToMany
    Collection<Prescription> prescriptions;


    public Drug(String name){
        this.name = name;
    }

}
