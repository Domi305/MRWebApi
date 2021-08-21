package com.dominiks.demo;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MarsRoverApiTest {

    @Test
    public void smallTest() {
        System.out.println("Hi there");
    }

    @Test
    public void restTemplateTest() {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY", String.class);
        System.out.println(response.getBody());

    }

    @Test
    public void restTemplateForTwoResponses() {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=DEMO_KEY", String.class);
        System.out.println(response.getBody());
    }
}
