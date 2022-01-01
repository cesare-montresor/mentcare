package it.univr.efcgang.mentcare.controller;

import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;
import it.univr.efcgang.mentcare.repository.PatientRepository;
import it.univr.efcgang.mentcare.repository.PrescriptionRepository;
import it.univr.efcgang.mentcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @GetMapping("/patient")
    public String index(Model model) {
        List<Patient> patients = new LinkedList<>();
        for(Patient p: repository.findAll())
            patients.add(p);
        model.addAttribute("patients", patients);
        return "patient/index";
    }

    @RequestMapping("patient/create")
    public String create(Model model){
        sendUsersToModel(model);
        return "patient/create";
    }

    @RequestMapping("patient/save")
    public String save(
            @RequestParam(name="name", required=true) String name,
            @RequestParam(name="doctor_id", required = true) long doctor_id,
            Model model) {

        sendUsersToModel(model);
        repository.save(new Patient(name,userRepository.findById(doctor_id)));
        return "redirect:/patient";
    }

    @RequestMapping("patient/edit")
    public String edit(
            @RequestParam(name="id", required=true) Long id,
            Model model) {
        Optional<Patient> result = repository.findById(id);
        //TODO: check if the result is found
        //TODO: put data in the model field to be displayed in the next page to edit them
        if(result.isPresent()) {
            sendPrescriptionsToModel(model, result.get());
            sendUsersToModel(model);

            model.addAttribute("patient", result);//serve nell'update
            return "patient/edit";
        }

        //TODO: in case no data is found, display the "notfound" page
        else
            return "notfound";
    }

    @RequestMapping("patient/update")
    public String update(
            @RequestParam(name="id", required=true) Long id,
            @RequestParam(name="name", required=true) String name,
            @RequestParam(name="doctor_id", required=true) long doctor_id,
            Model model) {
        Optional<Patient> result = repository.findById(id);

        //TODO: check if the result is found
        //TODO: delete the old person and add a new person
        if(result.isPresent()){
            repository.delete(result.get());
            //similmente senza applicare i metodi set
            repository.save(new Patient(name, userRepository.findById(doctor_id)));

            return "redirect:/patient";

        }
        //TODO: in case no data is found, display the "notfound" page
        else
            return "notfound";
    }


    @RequestMapping("patient/delete")
    public String delete(
            @RequestParam(name="id", required=true) Long id) {
        //TODO: check if the result is found
        //TODO: delete the old person
        Optional<Patient> result = repository.findById(id);
        if(result.isPresent()) {
            repository.delete(result.get());
            return "redirect:/patient";
        }
        //TODO: in case no data is found, display the "notfound" page
        return "notfound";
    }

    private void sendUsersToModel(Model model) {
        List<User> doctors = new LinkedList<>();
        for(User u: userRepository.findByRole("doctor"))
            doctors.add(u);
        model.addAttribute("doctors", doctors);

    }
    private void sendPrescriptionsToModel(Model model, Patient patient) {
        List<Prescription> prescriptions = new LinkedList<>();
        for(Prescription p: prescriptionRepository.findByPatient(patient))
            prescriptions.add(p);
        model.addAttribute("prescriptions", prescriptions);

    }


}