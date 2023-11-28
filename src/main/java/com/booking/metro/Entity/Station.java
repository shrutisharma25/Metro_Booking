package com.booking.metro.Entity;

import java.util.Map;

public class Station {
    private Map<String,String> name;
    private Map<String,Boolean> startStation;
    private Map<String,Boolean> lastStation;
    private Map<String,Integer> price;
    
    
    
	public Station(Map<String, String> name, Map<String, Boolean> startStation, Map<String, Boolean> lastStation,
			Map<String, Integer> price) {
		super();
		this.name = name;
		this.startStation = startStation;
		this.lastStation = lastStation;
		this.price = price;
	}
	public Station() {
		super();
	}
	
	public Map<String, String> getName() {
		return name;
	}
	public void setName(Map<String, String> name) {
		this.name = name;
	}
	public Map<String, Boolean> getStartStation() {
		return startStation;
	}
	public void setStartStation(Map<String, Boolean> startStation) {
		this.startStation = startStation;
	}
	public Map<String, Boolean> getLastStation() {
		return lastStation;
	}
	public void setLastStation(Map<String, Boolean> lastStation) {
		this.lastStation = lastStation;
	}
	public Map<String, Integer> getPrice() {
		return price;
	}
	public void setPrice(Map<String, Integer> price) {
		this.price = price;
	}
    
    
    




}



