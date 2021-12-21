package it.univr.efcgang.mentcare.controller;

import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class PatientController {

    @GetMapping("/patient/")
    public String index() {
        return "patient/index";

    }
    @RequestMapping("/patient/list")
    public String list(Model model) {
        List<Patient> patients = new LinkedList<>();
        for(Patient p: repository.findAll())
            patients.add(p);
        model.addAttribute("patients", patients);
        return "patient/list";
    }



}