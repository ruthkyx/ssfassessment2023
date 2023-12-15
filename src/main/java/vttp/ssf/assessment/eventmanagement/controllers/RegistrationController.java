package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vttp.ssf.assessment.eventmanagement.models.Register;

@Controller
public class RegistrationController {


    // TODO: Task 6

    @GetMapping("/register")
    public String register(Model model) {
        // model.addAttribute();

        return "";
    }

    // TODO: Task 7

    @PostMapping("/register")
    public String postRegister(@ModelAttribute Register user, Model model) {
        
        if() {
            // success 
            
            return "view2";
        } else {
            // fail

            return "view3";
        }

    }
}
