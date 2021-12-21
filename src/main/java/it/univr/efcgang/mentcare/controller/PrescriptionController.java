package it.univr.efcgang.mentcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PrescriptionController {

    @GetMapping("/prescription")
    public String index() {

        return "prescription/index";
    }

    @RequestMapping("/create")
    public String create(
            @RequestParam(name="patient_id", required=true) long patient_id,
            @RequestParam(name="drug_id", required=true) long drug_id,
            @RequestParam(name="dosage",required = true) String dosage){

        // TODO: will save in the repository once we have one
        // repository.save(new Person(firstname,lastname))
        return "redirect:/prescription";
    }

}
