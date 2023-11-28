package com.booking.metro.Services;

//StationServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import com.booking.metro.Entity.Station;
import com.booking.metro.Repository.StationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {

 @Autowired
 private StationRepository stationRepository;

 @Override
 public void initializeStationsFromJson() {
     try {
         // Load stations from the JSON file
         Resource resource = new ClassPathResource("stations.json");
         byte[] jsonData = FileCopyUtils.copyToByteArray(resource.getInputStream());
         String jsonString = new String(jsonData, StandardCharsets.UTF_8);

         // Map JSON to Station objects
         ObjectMapper objectMapper = new ObjectMapper();
         Station[] stations = objectMapper.readValue(jsonString, Station[].class);

         // Save stations to the database
         stationRepository.saveAll(Arrays.asList(stations));
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

 @Override
 public List<Station> getAllStations() {
     return stationRepository.findAll();
 }
}


