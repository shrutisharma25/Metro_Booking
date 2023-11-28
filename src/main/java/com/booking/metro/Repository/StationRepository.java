package com.booking.metro.Repository;
// StationRepository.java
//StationRepository.java
import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.metro.Entity.Station;

import java.util.List;

public interface StationRepository extends MongoRepository<Station, String> {
 List<Station> findByName(String name);
}
