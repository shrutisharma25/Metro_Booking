package com.booking.metro.Entity;
//Station.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stations")
public class Station {
 @Id
 private String id;

 private String name;
 private boolean startStation;
 private boolean lastStation;
 private int price;

 // Getters and setters (omitted for brevity)

 public Station() {
 }

 public Station(String name, boolean startStation, boolean lastStation, int price) {
     this.name = name;
     this.startStation = startStation;
     this.lastStation = lastStation;
     this.price = price;
 }
}
