package com.booking.metro.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "tickets")
@Getter
@Setter
public class Ticket {
    @Id
    private String id;

    private String startStation;
    private String endStation;
    private LocalDateTime generatedTime;
    private int usageCount;
    
	public Ticket() {
		super();
	}

	public void setStartStation(String startStation2) {
		
	}

	public void setEndStation(String endStation2) {
		
	}

	public void setGeneratedTime(LocalDateTime now) {
		
	}

	public void setUsageCount(int i) {
		
	}

	public Object getStartStation() {
		return null;
	}

	public Object getEndStation() {
		return null;
	}

	public int getUsageCount() {
		return 0;
	}

	public LocalDateTime getGeneratedTime() {
		return null;
	}
    
}
