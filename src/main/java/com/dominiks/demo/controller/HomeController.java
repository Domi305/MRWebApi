package com.dominiks.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomeView(Model model) {
        model.addAttribute("nameAndSurnameInitial", "Dominik S");
        return "index";
    }
}
