package com.booking.metro.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.metro.Entity.Station;
import com.booking.metro.Entity.Ticket;
import com.booking.metro.Repository.StationRepository;
import com.booking.metro.Repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private StationRepository stationRepository;

    @Override
    public Ticket generateTicket(String startStation, String endStation) {
        
        Station startStationEntity = stationRepository.findByName(startStation);
        Station endStationEntity = stationRepository.findByName(endStation);

        if (startStationEntity == null || endStationEntity == null) {
            throw new IllegalArgumentException("Invalid stations");
        }

        
        double ticketPrice = calculateTicketPrice(startStationEntity, endStationEntity);

        // Create a new ticket entity
        Ticket ticket = new Ticket();
        ticket.setStartStation(startStation);
        ticket.setEndStation(endStation);
        ticket.setGeneratedTime(LocalDateTime.now());
        ticket.setUsageCount(0);

        ticket = ticketRepository.save(ticket);

        return ticket;
    }

    @Override
    public boolean useTicket(Long ticketId, String station, boolean entering) {
       
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);

        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();

            if (isTicketExpired(ticket)) {
                throw new IllegalStateException("Ticket has expired");
            }

            if (ticket.getUsageCount() >= 2) {
                throw new IllegalStateException("Ticket has reached its usage limit");
            }

            if ((entering && !ticket.getStartStation().equals(station)) ||
                (!entering && !ticket.getEndStation().equals(station))) {
                throw new IllegalStateException("Invalid station for ticket usage");
            }

            ticket.setUsageCount(ticket.getUsageCount() + 1);
            ticketRepository.save(ticket);

            return true;
        }

        return false;
    }

    private double calculateTicketPrice(Station startStation, Station endStation) {

        if (startStation == null || endStation == null) {
            throw new IllegalArgumentException("Invalid start or end station");
        }

        double ticketPrice = Math.abs(endStation.getTicketPrice() - startStation.getTicketPrice());

        return ticketPrice;
    }


    private boolean isTicketExpired(Ticket ticket) {
        
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket");
        }

        LocalDateTime expiryTime = ticket.getGeneratedTime().plusHours(18);

        return LocalDateTime.now().isAfter(expiryTime);
    }

}

