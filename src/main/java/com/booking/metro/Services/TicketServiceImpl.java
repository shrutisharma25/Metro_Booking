package com.booking.metro.Services;// TicketServiceImpl.java

//TicketServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.metro.Entity.Ticket;
import com.booking.metro.Repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

 @Autowired
 private TicketRepository ticketRepository;

 @Override
 public String buyTicket(String startStation, String endStation) {
     // Generate a unique ticketId (you can use UUID or any other method)
     String ticketId = generateUniqueTicketId();

     Ticket ticket = new Ticket();
     ticket.setTicketId(ticketId);
     ticket.setStartStation(startStation);
     ticket.setEndStation(endStation);
     ticket.setPurchaseTime(LocalDateTime.now());
     ticket.setUsesRemaining(2);

     ticketRepository.save(ticket);

     return ticketId;
 }

 @Override
 public boolean enterStation(String ticketId) {
     List<Ticket> tickets = ticketRepository.findByTicketId(ticketId);

     if (tickets.isEmpty()) {
         return false; // Ticket not found
     }

     Ticket ticket = tickets.get(0);

     if (ticket.getUsesRemaining() > 0) {
         ticket.setUsesRemaining(ticket.getUsesRemaining() - 1);
         ticketRepository.save(ticket);
         return true; // Successfully entered the station
     }

     return false; // No uses remaining
 }

 @Override
 public boolean exitStation(String ticketId) {
     List<Ticket> tickets = ticketRepository.findByTicketId(ticketId);

     if (tickets.isEmpty()) {
         return false; // Ticket not found
     }

     // Assuming exiting a station does not affect usesRemaining

     return true; // Successfully exited the station
 }

 @Override
 public List<Ticket> getAllTickets() {
     return ticketRepository.findAll();
 }

 private String generateUniqueTicketId() {
     // Implement your logic to generate a unique ticketId
     // This can be a UUID or any other method
     return "TICKET_" + LocalDateTime.now().toString();
 }
}
