package it.univr.efcgang.mentcare.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    Drug drug;
    @ManyToOne(cascade = CascadeType.REFRESH)
    Patient patient;
    @ManyToOne(cascade = CascadeType.REFRESH)
    User doctor;

    private String dosage;
    private Date dateStart;
    private Date dateEnd;
    private boolean valid;

    public Prescription(Drug drug, Patient patient, User doctor, String dosage, Date dateStart,  Date dateEnd ){
        this.drug = drug;
        this.patient = patient;
        this.doctor=doctor;
        this.dosage=dosage;
        this.dateStart=dateStart;
        this.dateEnd=dateEnd;
        valid = checkValidity();
    }

    public boolean getValidity(){ return valid;}

    /***
     * Checks if the created prescription is valid.
     * @return
     */
    private boolean checkValidity(){

        // 1. Check dateEnd comes after dateStart
        boolean result = dateEnd.compareTo(dateStart) >= 0 ? true : false;
        System.out.println(dateStart+ " " + dateEnd + ": "+ result);

        return result;
    }


}
