package com.dominiks.demo.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeDto {

//    @RequestParam(required = false) String marsApiRoverData,
//    @RequestParam(required = false) Integer marsSol,
//    @RequestParam(required = false) Boolean defaultCheck1

    private String marsApiRoverData;
    private Integer marsSol;

    private Boolean cameraFhaz;
    private Boolean cameraRhaz;
    private Boolean cameraMast;
    private Boolean cameraChemcam;
    private Boolean cameraMahli;
    private Boolean cameraMardi;
    private Boolean cameraNavcam;
    private Boolean cameraPancam;
    private Boolean cameraMinites;

//    private Boolean defaultCheck1;
}
