package it.univr.efcgang.mentcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PrescriptionController {

    @GetMapping("/prescription")
    public String index() {

        return "prescription/index";
    }
    @GetMapping("/prescription/create")
    public String createPrescription() {

        return "prescription/create";
    }


}
