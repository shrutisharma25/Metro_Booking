package com.booking.metro.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booking.metro.Entity.Station;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final String apiUrl = "https://shrutisharma25.github.io/Table__API/stations.json";

    @GetMapping("/initialize")
    public Station[] getStations() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, Station[].class);
    }
}

