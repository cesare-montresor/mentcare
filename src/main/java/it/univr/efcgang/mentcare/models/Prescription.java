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
    private String validDescription = "";


    public Prescription(Drug drug, Patient patient, User doctor, String dosage, Date dateStart,  Date dateEnd ){
        this.drug = drug;
        this.patient = patient;
        this.doctor=doctor;
        this.dosage=dosage;
        this.dateStart=dateStart;
        this.dateEnd=dateEnd;
        checkValidity();
    }

    public boolean getValidity(){ return valid;}

    /***
     * Checks if the created prescription is valid.
     * @return
     */
    /***
     * Checks if the created prescription is valid.
     * @return
     */
    private void checkValidity(){

        boolean isNotEmpty = true;

        if(drug==null) {
            validDescription += "Drug is not set. ";
            isNotEmpty = isNotEmpty && false; // messo in ogni riga perché IntelliJ altrimenti mi dava errore...
        }
        if(patient == null) {
            validDescription += "Patient is not set. ";
            isNotEmpty = isNotEmpty && false;
        }
        if(doctor == null) {
            validDescription += "User is not set; something went wrong in authentication. ";
            isNotEmpty = isNotEmpty && false;
        }
        if (dosage.equals("")) {
            validDescription += "Dosage is not set.";
            isNotEmpty = isNotEmpty && false;
        }
        if (dateStart == null) {
            validDescription += "Start date is not set. ";
            isNotEmpty = isNotEmpty && false;
        }
        if (dateEnd == null) {
            validDescription += "End date is not set. ";
            isNotEmpty = isNotEmpty && false;
        }

        if (isNotEmpty == false)
            valid = false;


        // Check dateEnd comes after dateStart
        boolean areDatesValid = dateStart.compareTo(dateEnd) <= 0 ? true : false;

        validDescription = areDatesValid == true ? validDescription : validDescription + "End date cannot be before start date.";


        valid = isNotEmpty && areDatesValid;

    }


}
