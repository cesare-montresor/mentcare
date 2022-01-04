package it.univr.efcgang.mentcare.config;

import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;
import it.univr.efcgang.mentcare.repository.DrugRepository;
import it.univr.efcgang.mentcare.repository.PatientRepository;
import it.univr.efcgang.mentcare.repository.PrescriptionRepository;
import it.univr.efcgang.mentcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class DemoData {

    @Autowired
    DrugRepository drugRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAuthDetailsService userAuthDetailsService;



    public boolean addDemoData() {
        System.out.println("Adding Demo Data");

        Drug drug1 = new Drug("drug A");
        drugRepository.save(drug1);
        drug1 = drugRepository.findById(drug1.getId()).get();

        // ------------ User
        User admin = userAuthDetailsService.UserAdd("admin", "admin", "admin", "ADMIN");
        User docMaria = userAuthDetailsService.UserAdd("maria", "maria", "maria", "DOCTOR");
        User docLuigi = userAuthDetailsService.UserAdd("luigi", "luigi", "luigi", "DOCTOR");

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

        long num_drugs = drugRepository.count();
        long num_users = userRepository.count();
        long num_patients = patientRepository.count();
        long num_prescriptions = prescriptionRepository.count();

        System.out.println("num_drugs: " + num_drugs);
        System.out.println("num_users: " + num_users);
        System.out.println("num_patients: " + num_patients);
        System.out.println("num_prescriptions: " + num_prescriptions);

        return true;
    }
}
