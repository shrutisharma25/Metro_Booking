package com.booking.metro.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.metro.Entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	Ticket save(Ticket ticket);

	Optional<Ticket> findById(Long ticketId);
}
