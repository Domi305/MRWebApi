package com.dominiks.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarsRover {
    private Long id;
    private String name;
    @JsonProperty("landing_date")
    private String landingDate;

    @Override
    public String toString() {
        return "MarsRover{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", landingDate='" + landingDate + '\'' +
                '}';
    }
}
