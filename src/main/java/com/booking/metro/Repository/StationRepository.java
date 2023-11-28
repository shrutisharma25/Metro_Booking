package com.booking.metro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.metro.Entity.Station;

public interface StationRepository extends MongoRepository<Station, String> {
    Station findByName(String name);
}
