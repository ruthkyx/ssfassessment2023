package vttp.ssf.assessment.eventmanagement.controllers;

import java.time.LocalDate;
import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Register;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping
public class RegistrationController {

    @Autowired
    private RedisRepository redisRepo;

    // TODO: Task 6

    @GetMapping("/register")
    public String register(Model model) {
        Register register = new Register();
        model.addAttribute("user", register);

        return "view1";
    }

    // TODO: Task 7

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute Register register, BindingResult br, Model model) {
        
        if(br.hasErrors()) {
            return "view3";
        }

        // server side validation 
        LocalDate birthdate = new LocalDate(dob);
        LocalDate now = new LocalDate();
        int age = (int) Year.yearsBetween(birthdate, now);
        int participants = template.opsForList().index("participants");

        if(age >= 21) {
            for(int i = 0, i < participants, i++) {
                return "view2";
            }
            
            return "view2";

        } else {
            // fail
            return "view3";
        }

    }
}
