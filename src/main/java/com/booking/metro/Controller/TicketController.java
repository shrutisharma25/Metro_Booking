package com.booking.metro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.metro.Entity.Ticket;
import com.booking.metro.Services.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/generate")
    public ResponseEntity<Ticket> generateTicket(@RequestParam String startStation, @RequestParam String endStation) {
        Ticket generatedTicket = ticketService.generateTicket(startStation, endStation);
        return new ResponseEntity<>(generatedTicket, HttpStatus.OK);
    }

    @PostMapping("/use")
    public ResponseEntity<String> useTicket(@RequestParam Long ticketId, @RequestParam String station, @RequestParam boolean entering) {
        boolean isUsed = ticketService.useTicket(ticketId, station, entering);

        if (isUsed) {
            return new ResponseEntity<>("Ticket used successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid ticket or usage limit reached", HttpStatus.BAD_REQUEST);
        }
    }
}

