package com.dominiks.demo.controller;

import com.dominiks.demo.response.MarsRoverApiResponse;
import com.dominiks.demo.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverApiService;

    @GetMapping("/")
    public String getHomeView(Model model, @RequestParam(required = false) String marsApiRoverData) {
        //if request param is empty, then set default value
        if (StringUtils.isEmpty(marsApiRoverData)) {
            marsApiRoverData = "curiosity";
        }
        MarsRoverApiResponse roverData = roverApiService.getRoverData(marsApiRoverData);
        model.addAttribute("roverData", roverData);
        return "index";
    }

/*    @PostMapping("/")
    public String postHomeView(Model model, @RequestParam String marsApiRoverData) {
        MarsRoverApiResponse roverData = roverApiService.getRoverData(marsApiRoverData);
        model.addAttribute("roverData", roverData);
        return "index";
    }*/
}
