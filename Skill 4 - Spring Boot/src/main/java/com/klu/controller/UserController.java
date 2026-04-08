package com.klu.controller;

import com.klu.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/home")
    public String home(Model model) {
        User user = new User("Alice", 25);
        model.addAttribute("user", user);
        return "home";
    }
}
