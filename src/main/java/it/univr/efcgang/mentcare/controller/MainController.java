package it.univr.efcgang.mentcare.controller;


import it.univr.efcgang.mentcare.config.SampleData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/init")
    public String init(){
        SampleData.sharedInstance.run();

        return "redirect:/";
    }


}