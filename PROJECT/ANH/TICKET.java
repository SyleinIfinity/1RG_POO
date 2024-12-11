package com.example;

import java.util.Date;

public class TICKET {
    private String idTicket;
    private String idFlight;
    private String idCustomer;
    private String idSeat;
    private Date bookingDate;
    private String TypeTicket;
    private String statusTicket;
    
    public TICKET() {
    }

    public TICKET(String TypeTicket, Date bookingDate, String idCustomer, String idFlight, String idSeat, String idTicket, String statusTicket) {
        this.TypeTicket = TypeTicket;
        this.bookingDate = bookingDate;
        this.idCustomer = idCustomer;
        this.idFlight = idFlight;
        this.idSeat = idSeat;
        this.idTicket = idTicket;
        this.statusTicket = statusTicket;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(String idSeat) {
        this.idSeat = idSeat;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTypeTicket() {
        return TypeTicket;
    }

    public void setTypeTicket(String TypeTicket) {
        this.TypeTicket = TypeTicket;
    }

    public String getStatusTicket() {
        return statusTicket;
    }

    public void setStatusTicket(String statusTicket) {
        this.statusTicket = statusTicket;
    }


    

}