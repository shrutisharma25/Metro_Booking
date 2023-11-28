package com.booking.metro.response;

import com.booking.metro.Entity.Station;

public class StationResponse {
    private Station[] stations;

    public StationResponse() {
    }

    public Station[] getStations() {
        return stations;
    }

    public void setStations(Station[] stations) {
        this.stations = stations;
    }
}
