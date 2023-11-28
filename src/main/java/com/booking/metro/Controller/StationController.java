package com.booking.metro.Controller;

//StationController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.metro.Entity.Station;
import com.booking.metro.Services.StationService;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationController {

 @Autowired
 private StationService stationService;

 @GetMapping("/initialize")
 public String initializeStations() {
     stationService.initializeStationsFromJson();
     return "Stations initialized successfully";
 }

 @GetMapping
 public List<Station> getAllStations() {
     return stationService.getAllStations();
 }
}
