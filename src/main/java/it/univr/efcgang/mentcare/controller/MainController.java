package it.univr.efcgang.mentcare.controller;

import it.univr.efcgang.mentcare.models.User;

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
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");

        return "redirect:/";
    }


}