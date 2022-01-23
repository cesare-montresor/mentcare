package it.univr.efcgang.mentcare.controller;

import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DrugController {

    @Autowired
    private DrugRepository drugRepo;

    @GetMapping("/drug")
    public String index( Model model ) {
        List<Drug> drugs = drugRepo.findAll();
        model.addAttribute("drugs", drugs);
        return "drug/index";
    }



}