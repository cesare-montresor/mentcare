package it.univr.efcgang.mentcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {

    @GetMapping("/patient*")
    public String index() {

        return "patient/index";
    }


}