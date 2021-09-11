package com.dominiks.demo.service;

import com.dominiks.demo.Dto.HomeDto;
import com.dominiks.demo.response.MarsPhoto;
import com.dominiks.demo.response.MarsRoverApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MarsRoverApiService {

    private static final String API_KEY = "EgHpwnMfoCkjbdLcN6eAh2kZXyDZeizIzoyD2Amq";

    private Map<String, List<String>> validCameras = new HashMap<>();

    public MarsRoverApiService() {

        validCameras.put("Curiosity", Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"));
        validCameras.put("Opportunity", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
        validCameras.put("Spirit", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
    }

    public MarsRoverApiResponse getRoverData(HomeDto homeDto) {
        RestTemplate rt = new RestTemplate();

        List<String> apiUrlEndpoints = getApiUrlEndpoints(homeDto);
        List<MarsPhoto> photos = new ArrayList<>();
        MarsRoverApiResponse response = new MarsRoverApiResponse();

        apiUrlEndpoints.stream()
                .forEach(url -> {
                    MarsRoverApiResponse apiResponse = rt.getForObject(url, MarsRoverApiResponse.class);
                    photos.addAll(apiResponse.getPhotos());
                });
        response.setPhotos(photos);

        return response;
    }

    public List<String> getApiUrlEndpoints(HomeDto homeDto) {
        List<String> urls = new ArrayList<>();

        Method[] methods = homeDto.getClass().getMethods();

         /*Code grabs all getCamera methods and if value returns true then we will build API URL to call
         in order to fetch pictures for given rover / camera type / sol(day)*/
        for (Method method : methods) {
            try {
                if (method.getName().indexOf("getCamera") > -1 && Boolean.TRUE.equals(method.invoke(homeDto))) {
                    String camName = method.getName().split("getCamera")[1].toUpperCase();
                    if (validCameras.get(homeDto.getMarsApiRoverData()).contains(camName)) {
                        urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera=" + camName);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }

    public Map<String, List<String>> getValidCameras() {
        return validCameras;
    }
}