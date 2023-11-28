package com.booking.metro.Services;

//StationService.java
import java.util.List;

import com.booking.metro.Entity.Station;

public interface StationService {
 void initializeStationsFromJson();
 List<Station> getAllStations();
}
