package com.example;

public class AIRPORT {
    private String AirportID;
    private String AirportName;
    private String CityID;

    public AIRPORT() {     
    }

    public AIRPORT(String AirportID, String AirportName, String CityID) {
        this.AirportID = AirportID;
        this.AirportName = AirportName;
        this.CityID = CityID;
    }
    
    public String getAirportID() {
        return AirportID;
    }

    public void setAirportID(String airportID) {
        AirportID = airportID;
    }

    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String airportName) {
        AirportName = airportName;
    }

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String CityID) {
        CityID = CityID;
    }
}
