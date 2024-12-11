package com.example;

public class FLIGHT {
    private String FlightID;
    private String FlightNumber;
    private String AirportID;
    private String CityID;
    private String DepartureTime;
    private String ArrivalTime;
    private String DefaultPrice;
    private int Available;
    private int Maximum;

    public FLIGHT() {
    }

    public FLIGHT(String AirportID, String ArrivalTime, int Available, String CityID, String DefaultPrice, String DepartureTime, String FlightID, String FlightNumber, int Maximum) {
        this.AirportID = AirportID;
        this.ArrivalTime = ArrivalTime;
        this.Available = Available;
        this.CityID = CityID;
        this.DefaultPrice = DefaultPrice;
        this.DepartureTime = DepartureTime;
        this.FlightID = FlightID;
        this.FlightNumber = FlightNumber;
        this.Maximum = Maximum;
    }

    public String getFlightID() {
        return FlightID;
    }
    public void setFlightID(String flightID) {
        FlightID = flightID;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public String getAirportID() {
        return AirportID;
    }
    public void setAirportID(String airportID) {
        AirportID = airportID;
    }

    public String getCityID() {
        return CityID;
    }
    public void setCityID(String cityID) {
        CityID = cityID;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }
    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public String getDefaultPrice() {
        return DefaultPrice;
    }
    public void setDefaultPrice(String defaultPrice) {
        DefaultPrice = defaultPrice;
    }

    public int getAvailable() {
        return Available;
    }
    public void setAvailable(int Available) {
        this.Available = Available;
    }

    public int getMaximum() {
        return Maximum;
    }
    public void setMaximum(int Maximum) {
        this.Maximum = Maximum;
    }



    
}