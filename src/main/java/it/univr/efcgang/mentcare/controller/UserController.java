package it.univr.efcgang.mentcare.controller;


import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.models.User;
import it.univr.efcgang.mentcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String getIndex(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user/index";
    }




}
