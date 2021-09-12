package com.dominiks.demo.controller;

import com.dominiks.demo.dto.HomeDto;
import com.dominiks.demo.response.MarsRoverApiResponse;
import com.dominiks.demo.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private MarsRoverApiService roverApiService;

    @GetMapping("/")
    public String getHomeView(Model model, Long userId, Boolean createUser) throws IllegalArgumentException {

        HomeDto homeDto = createDefaultHomeDto(userId);

        if (Boolean.TRUE.equals(createUser) && userId == null) {
            homeDto = roverApiService.save(homeDto);
        } else {
            homeDto = roverApiService.findByUserId(userId);
            if (homeDto == null) {
                homeDto = createDefaultHomeDto(userId);
            }
        }

        MarsRoverApiResponse roverData = roverApiService.getRoverData(homeDto);
        model.addAttribute("roverData", roverData);
        model.addAttribute("homeDto", homeDto);
        model.addAttribute("validCameras", roverApiService.getValidCameras().get(homeDto.getMarsApiRoverData()));
        if (!Boolean.TRUE.equals(homeDto.getRememberPreferences()) && userId != null) {
            HomeDto defaultHomeDto = createDefaultHomeDto(userId);
            roverApiService.save(defaultHomeDto);
        }

        return "index";
    }

    @GetMapping("/savedPreferences")
    @ResponseBody
    public HomeDto getSavedPreferences(Long userId) {
        if (userId != null)
            return roverApiService.findByUserId(userId);
        else
            return createDefaultHomeDto(userId);
    }

    private HomeDto createDefaultHomeDto(Long userId) {
        HomeDto homeDto = new HomeDto();
        homeDto.setMarsApiRoverData("Curiosity");
        homeDto.setMarsSol(1);
        homeDto.setUserId(userId);
        return homeDto;
    }

    @PostMapping("/")
    public String postHomeView(@ModelAttribute(value = "homeDto") HomeDto postData) {
        postData = roverApiService.save(postData);
        System.out.println(postData);
        return "redirect:/?userId=" + postData.getUserId();
    }
}
