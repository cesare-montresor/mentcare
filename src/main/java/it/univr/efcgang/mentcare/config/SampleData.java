package it.univr.efcgang.mentcare.config;

import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;

import it.univr.efcgang.mentcare.repository.DrugRepository;
import it.univr.efcgang.mentcare.repository.PatientRepository;
import it.univr.efcgang.mentcare.repository.PrescriptionRepository;
import it.univr.efcgang.mentcare.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

@Setter
@Getter
public class SampleData {

    public static final SampleData sharedInstance = new SampleData();

    @Autowired DrugRepository drugRepository;
    @Autowired PatientRepository patientRepository;
    @Autowired PrescriptionRepository prescriptionRepository;
    @Autowired UserRepository userRepository;


    public boolean run(){
        // ------------ Drug
        Drug drug1 = new Drug("drug A");
        drugRepository.save(drug1);

        // ------------ User
        User admin = new User("admin","admin","admin","ADMIN");
        User docMaria = new User("maria","maria","mario","DOCTOR");
        User docLuigi = new User("luigi","luigi","luigi","DOCTOR");
        userRepository.save(admin);
        userRepository.save(docMaria);
        userRepository.save(docLuigi);

        // ------------ Patient
        Patient patient1 = new Patient("Giovanni Rossi", docMaria);
        Patient patient2 = new Patient("Andrea Andrei", docLuigi);
        patientRepository.save(patient1);
        patientRepository.save(patient2);

        // ------------ Prescription
        Calendar cal = Calendar.getInstance();
        Date today = new Date();
        Date tomorrow, nextWeek, nextMonth;

        cal.setTime(today);
        cal.add(Calendar.DATE, 1); // 10 is the days you want to add or subtract
        tomorrow = cal.getTime();

        cal.setTime(today);
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        nextWeek = cal.getTime();

        cal.setTime(today);
        cal.add(Calendar.MONTH, 1);
        nextMonth = cal.getTime();

        Date yesterday = cal.getTime();
        Prescription presc1 = new Prescription(drug1, patient2, docMaria, "3 dia", today, nextMonth);
        prescriptionRepository.save(presc1);


        return true;
    }
}
