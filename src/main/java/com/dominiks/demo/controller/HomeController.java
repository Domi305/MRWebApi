package com.dominiks.demo.controller;

import com.dominiks.demo.response.MarsRoverApiResponse;
import com.dominiks.demo.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverApiService;

    @GetMapping("/")
    public String getHomeView(Model model) {
        MarsRoverApiResponse roverData = roverApiService.getRoverData("opportunity");
        model.addAttribute("roverData", roverData);
        return "index";
    }
}
