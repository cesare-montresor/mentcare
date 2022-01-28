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
    AuthService authService;



    public boolean addDemoData() {
        System.out.println("Adding Demo Data");

        // ------------ User
        User guest = authService.UserAdd("guest", "guest", "guest", "GUEST");
        User admin = authService.UserAdd("admin", "admin", "admin", "ADMIN");
        User docMaria = authService.UserAdd("maria", "maria", "maria", "DOCTOR");
        User docLuigi = authService.UserAdd("luigi", "luigi", "luigi", "DOCTOR");
        User offUgo = authService.UserAdd("ugo", "ugo", "ugo", "OFFICE");


        // ------------ Drug
        Drug drug1 = new Drug("drug A");
        Drug drug2 = new Drug("drug B");
        Drug drug3 = new Drug("drug C");
        Drug drug4 = new Drug("drug D");
        Drug drug5 = new Drug("drug E");
        Drug drug6 = new Drug("drug F");
        Drug drug7 = new Drug("drug G");
        Drug drug8 = new Drug("drug H");

        drugRepository.save(drug1);
        drugRepository.save(drug2);
        drugRepository.save(drug3);
        drugRepository.save(drug4);
        drugRepository.save(drug5);
        drugRepository.save(drug6);
        drugRepository.save(drug7);
        drugRepository.save(drug8);



        // ------------ Patient
        Patient patient1 = new Patient("Giovanni Rossi", docMaria);
        Patient patient2 = new Patient("Andrea Andrei", docLuigi);
        Patient patient3 = new Patient("Mario Rossi", docMaria);
        Patient patient4 = new Patient("Giuseppe Verdi", docLuigi);
        Patient patient5 = new Patient("Mario Bianchi", docMaria);
        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);
        patientRepository.save(patient5);

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

        /*
        System.out.println("num_drugs: " + num_drugs);
        System.out.println("num_users: " + num_users);
        System.out.println("num_patients: " + num_patients);
        System.out.println("num_prescriptions: " + num_prescriptions);
        */

        return true;
    }

    public void clearDemoData(){
        userRepository.deleteAll();
        drugRepository.deleteAll();
        patientRepository.deleteAll();
        prescriptionRepository.deleteAll();
    }

    public void resetDemoData(){
        clearDemoData();
        addDemoData();
    }

    /*
    public void printAllRepository(){
        System.out.println("Printing all patients: \n");
        for(Patient p: patientRepository.findAll())
            System.out.println(p);
        System.out.println("Printing all users: \n");
        for(User u: userRepository.findAll())
            System.out.println(u);

    }*/
}
