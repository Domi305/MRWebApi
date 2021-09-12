package com.dominiks.demo.controller;

import com.dominiks.demo.dto.HomeDto;
import com.dominiks.demo.repository.PreferencesRepository;
import com.dominiks.demo.response.MarsRoverApiResponse;
import com.dominiks.demo.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverApiService;

    @GetMapping("/")
    public String getHomeView(Model model, HomeDto homeDto) throws IllegalArgumentException {
        //if request param is empty, then set default value
        if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())) {
            homeDto.setMarsApiRoverData("Curiosity");
        }
        if (homeDto.getMarsSol() == null)
            homeDto.setMarsSol(1);

        MarsRoverApiResponse roverData = roverApiService.getRoverData(homeDto);
        model.addAttribute("roverData", roverData);
        model.addAttribute("homeDto", homeDto);
        model.addAttribute("validCameras", roverApiService.getValidCameras().get(homeDto.getMarsApiRoverData()));

        return "index";
    }

    @PostMapping("/")
    public String postHomeView(@ModelAttribute(value = "homeDto") HomeDto postData) {
        roverApiService.save(postData);
        System.out.println(postData);
        return "redirect:/";
    }
}
