package com.booking.metro.Entity;
//Ticket.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tickets")
public class Ticket {
 @Id
 private String id;

 private String ticketId;
 private String startStation;
 private String endStation;
 private LocalDateTime purchaseTime;
 private int usesRemaining;

 // No need for User association

 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }

 public String getTicketId() {
     return ticketId;
 }

 public void setTicketId(String ticketId) {
     this.ticketId = ticketId;
 }

 public String getStartStation() {
     return startStation;
 }

 public void setStartStation(String startStation) {
     this.startStation = startStation;
 }

 public String getEndStation() {
     return endStation;
 }

 public void setEndStation(String endStation) {
     this.endStation = endStation;
 }

 public LocalDateTime getPurchaseTime() {
     return purchaseTime;
 }

 public void setPurchaseTime(LocalDateTime purchaseTime) {
     this.purchaseTime = purchaseTime;
 }

 public int getUsesRemaining() {
     return usesRemaining;
 }

 public void setUsesRemaining(int usesRemaining) {
     this.usesRemaining = usesRemaining;
 }
}
