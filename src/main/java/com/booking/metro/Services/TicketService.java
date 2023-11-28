package com.booking.metro.Services;

import com.booking.metro.Entity.Ticket;

public interface TicketService {
    Ticket generateTicket(String startStation, String endStation);

    boolean useTicket(Long ticketId, String station, boolean entering);
}
