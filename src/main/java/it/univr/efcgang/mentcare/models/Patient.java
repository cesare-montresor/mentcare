package it.univr.efcgang.mentcare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean valid;
    private String validDescription = "";
    @ManyToOne(cascade = CascadeType.REFRESH)
    User mainDoctor;

    @OneToMany(mappedBy = "patient", orphanRemoval = true, cascade = CascadeType.ALL)
    Collection<Prescription> prescriptions;

    public Patient(String name, User mainDoctor) {
        this.name = name;
        this.mainDoctor = mainDoctor;
        checkValidity();
    }

    private void checkValidity(){
        boolean isNotEmpty = true;
        if(name == null || name.equals("")) {
            validDescription += "Patient name is not set. ";
            isNotEmpty = false;
        }
        if(mainDoctor == null){
            validDescription += "Doctor is not set. ";
            isNotEmpty = false;
        }
        if(isNotEmpty == false)
            valid = false;
    }
    /*
    @Override
    public String toString(){
        return "Id: "+ id + "\nName: " + name + " \nDoctor: " + mainDoctor.toString();
    }*/
}
