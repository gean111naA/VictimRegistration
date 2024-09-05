package com.example.VictimRegistration.controller;

import com.example.VictimRegistration.model.Victim;
import com.example.VictimRegistration.repository.VictimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class VictimController {

    @Autowired
    private VictimRepository victimRepository;

    @GetMapping("/victim/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("victim", new Victim());
        return "register";
    }

    @PostMapping("/victim/register")
    public String registerVictim(@Valid Victim victim, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
           
            System.out.println("Binding errors found: " + bindingResult.getAllErrors());
            return "register";
        }

        try {
            victimRepository.save(victim);
            model.addAttribute("message", "Victim registered successfully!");
            return "success";
            
        } catch (Exception e) {
            // Loghează eroarea și returnează o pagină de eroare
            e.printStackTrace();
            model.addAttribute("message", "An error occurred while registering the victim.");
            return "error";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Model model, Exception e) {
        model.addAttribute("message", "An unexpected error occurred: " + e.getMessage());
        return "error";
    }
}




