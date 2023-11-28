package com.booking.metro.Controller;

//TicketController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.booking.metro.Entity.Ticket;
import com.booking.metro.Services.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

 @Autowired
 private TicketService ticketService;

 @PostMapping("/buy")
 public String buyTicket(@RequestParam String startStation, @RequestParam String endStation) {
     return ticketService.buyTicket(startStation, endStation);
 }

 @PostMapping("/enter")
 public String enterStation(@RequestParam String ticketId) {
     if (ticketService.enterStation(ticketId)) {
         return "Entered the station successfully";
     } else {
         return "Failed to enter the station";
     }
 }

 @PostMapping("/exit")
 public String exitStation(@RequestParam String ticketId) {
     if (ticketService.exitStation(ticketId)) {
         return "Exited the station successfully";
     } else {
         return "Failed to exit the station";
     }
 }

 @GetMapping("/all")
 public List<Ticket> getAllTickets() {
     return ticketService.getAllTickets();
 }
}


