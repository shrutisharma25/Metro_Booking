package com.booking.metro.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "stations")
@Getter
@Setter
public class Station {
    @Id
    private String id;

    private String name;
    private double ticketPrice;
    
    
	public Station() {
		super();
	}

	public void setTicketPrice(double ticketPrice2) {
		
	}
	public int getTicketPrice() {
		return 0;
	}
    
    
}
