package it.univr.efcgang.mentcare.controller;

import it.univr.efcgang.mentcare.config.AuthService;

import it.univr.efcgang.mentcare.repository.DrugRepository;
import it.univr.efcgang.mentcare.repository.PatientRepository;
import it.univr.efcgang.mentcare.repository.PrescriptionRepository;
import it.univr.efcgang.mentcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @Autowired
    AuthService authService;

    @GetMapping("/utils")
    public String index() {
        return "utils/index";
    }


    @GetMapping("/utils/statsDatabase")
    public String initDatabase(Model model){
        long num_drugs = drugRepository.count();
        long num_users = userRepository.count();
        long num_patients = patientRepository.count();
        long num_prescriptions = prescriptionRepository.count();

        model.addAttribute("num_drugs", num_drugs);
        model.addAttribute("num_users", num_users);
        model.addAttribute("num_patients", num_patients);
        model.addAttribute("num_prescriptions", num_prescriptions);

        return "utils/statsDatabase";
    }

}
