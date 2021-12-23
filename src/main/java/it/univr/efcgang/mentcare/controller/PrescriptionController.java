package it.univr.efcgang.mentcare.controller;

import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.repository.DrugRepository;
import it.univr.efcgang.mentcare.repository.PatientRepository;
import it.univr.efcgang.mentcare.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Controller
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/prescription")
    public String index(Model model) {

        List<Prescription> data = new LinkedList<>();
        for (Prescription p: prescriptionRepository.findAll()){
            data.add(p);
        }
        model.addAttribute("prescriptions", data);

        return "prescription/index";
    }

    @RequestMapping("prescription/create")
    public String create(Model model){

        // I need to send info about available patients and drugs to the model.

        // Patients:
        List<Patient> data = new LinkedList<>();
        for (Patient p: patientRepository.findAll()){
            data.add(p);
        }
        model.addAttribute("patients",data);

        // Drugs:
        List<Drug> data_d = new LinkedList<>();
        for (Drug d: drugRepository.findAll()){
            data_d.add(d);
        }

        model.addAttribute("drugs",data_d);


        return "prescription/create";
    }
    @RequestMapping("prescription/save")
    public String save(@RequestParam(name="patient_id", required=true) long patient_id,
                       @RequestParam(name="drug_id", required=true) long drug_id,
                       @RequestParam(name="dosage",required = true) String dosage,
                       @RequestParam(name="dateStart",required=true)
                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateStart,
                       @RequestParam(name="dateEnd",required=true)
                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateEnd){

        // TODO: will save in the repository once we have one
        // TODO: check that end date is bigger than start date

        // Find patient and drug
        Patient patient = patientRepository.findById(patient_id);
        Drug drug = drugRepository.findById(drug_id);

        if (patient == null || drug == null)
            return "notfound";

        // Make prescription
        Prescription prescription = new Prescription(drug,patient,null,dosage, dateStart, dateEnd);

        prescriptionRepository.save(prescription);

        return "redirect:/prescription";
    }

    @RequestMapping("/delete")
    public String delete(
            @RequestParam(name="id", required=true) Long id) {

        Optional<Prescription> result = prescriptionRepository.findById(id);

        if(result.isPresent()){
            prescriptionRepository.delete(result.get());
            return "redirect:/prescription";
        }

        return "notfound";
    }
}
