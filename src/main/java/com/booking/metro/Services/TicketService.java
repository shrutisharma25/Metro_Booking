package com.booking.metro.Services;

//TicketService.java
import java.util.List;

import com.booking.metro.Entity.Ticket;

public interface TicketService {
 String buyTicket(String startStation, String endStation);
 boolean enterStation(String ticketId);
 boolean exitStation(String ticketId);
 List<Ticket> getAllTickets();
}

