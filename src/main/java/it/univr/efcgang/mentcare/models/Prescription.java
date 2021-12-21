package it.univr.efcgang.mentcare.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    Drug drug;
    @ManyToOne
    Patient patient;
    @ManyToOne
    User doctor;

    String dosage;
    Date dateStart;
    Date dateEnd;

    public Prescription(Drug drug, Patient patient, User doctor, String dosage, Date dateStart,  Date dateEnd ){
        this.drug = drug;
        this.patient = patient;
        this.doctor=doctor;
        this.dosage=dosage;
        this.dateStart=dateStart;
        this.dateEnd=dateEnd;
    }
}
