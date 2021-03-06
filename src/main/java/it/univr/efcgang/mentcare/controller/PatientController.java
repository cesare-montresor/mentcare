package it.univr.efcgang.mentcare.controller;

import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;
import it.univr.efcgang.mentcare.repository.PatientRepository;
import it.univr.efcgang.mentcare.repository.PrescriptionRepository;
import it.univr.efcgang.mentcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
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
    public String create(
            @RequestParam(name = "error_msg", required = false) String error_msg,
            Model model){
        model.addAttribute("error_msg",error_msg);

        sendUsersToModel(model);

        return "patient/create";
    }

    @RequestMapping("patient/save")
    public String save(
            @RequestParam(name="name", required=true) String name,
            @RequestParam(name="doctor_id", required = true) long doctor_id,
            Model model) {
        User doctor = userRepository.findById(doctor_id);
        Patient p = new Patient(name, doctor);
        if(p.isValid()){
            repository.save(p);

        }else{
            return "redirect:/patient/create?error_msg=" + p.getValidDescription();
        }

        return "redirect:/patient";
    }

    @RequestMapping("patient/edit")
    public String edit(
            @RequestParam(name="id", required=true) Long id,
            @RequestParam(name = "error_msg", required = false) String error_msg,
            Model model) {
        Optional<Patient> result = repository.findById(id);
        //TODO: check if the result is found
        //TODO: put data in the model field to be displayed in the next page to edit them
        if(result.isPresent()) {
            sendUsersToModel(model);
            model.addAttribute("error_msg",error_msg);

            model.addAttribute("patient", result.get());//serve nell'update


            return "patient/edit";
        }

        else
            return "patient/notfound";
    }

    @RequestMapping("patient/update")
    public String update(
            @RequestParam(name="id", required=true) Long id,
            @RequestParam(name="name", required=true) String name,
            @RequestParam(name="doctor_id", required=true) long doctor_id,
            Model model) {
        Optional<Patient> result = repository.findById(id);
        Patient p = new Patient(name, userRepository.findById(doctor_id));
        if(result.isPresent()){
            if(p.isValid()){
                repository.delete(result.get());
                //similmente senza applicare i metodi set
                repository.save(p);
                return "redirect:/patient";

            }else{
                System.out.println("ValidDescription: "+ p.getValidDescription());
                return "redirect:/patient/edit?id="+ id +"&error_msg=" + p.getValidDescription();
            }

        }
        else
            return "patient/notfound";
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
        return "patient/notfound";
    }

    private void sendUsersToModel(Model model) {
        List<User> doctors = new LinkedList<>();
        for (User u : userRepository.findByRolesContains("DOCTOR")){
            doctors.add(u);
            //System.out.println("Id: "+ u.getId() + "Name: "+ u.getName());
        }
        model.addAttribute("doctors", doctors);

    }

}