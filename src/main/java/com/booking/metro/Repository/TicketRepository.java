package com.booking.metro.Repository;

//TicketRepository.java
import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.metro.Entity.Ticket;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket, String> {
 List<Ticket> findByTicketId(String ticketId);
}


