package it.univr.efcgang.mentcare.controller;

import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;

import it.univr.efcgang.mentcare.repository.DrugRepository;
import it.univr.efcgang.mentcare.repository.PatientRepository;
import it.univr.efcgang.mentcare.repository.PrescriptionRepository;
import it.univr.efcgang.mentcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.Date;


@Controller
public class UtilsController {


    @Autowired
    DrugRepository drugRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/utils")
    public String index() {
        return "utils/index";
    }

    @GetMapping("/utils/initDatabase")
    public String initDatabase(Model model){
        Drug drug1 = new Drug("drug A");
        drugRepository.save(drug1);
        drug1 = drugRepository.findById(drug1.getId()).get();

        // ------------ User
        User admin = new User("admin","admin","admin","ADMIN");
        User docMaria = new User("maria","maria","maria","DOCTOR");
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

        model.addAttribute("num_drugs", 1);
        model.addAttribute("num_users", 3);
        model.addAttribute("num_patients", 2);
        model.addAttribute("num_prescriptions", 1);

        return "utils/initDatabase";
    }
}
