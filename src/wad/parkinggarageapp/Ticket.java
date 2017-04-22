/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.parkinggarageapp;

/**
 *
 * @author Billy-Mac
 */
public class Ticket {
    private final String EXCEPTION = "Error with Ticket";
    private String garageName;
    private double hoursParked;
    private double fee;
    private static int ticketNumber;
    
    public Ticket(String garageName, int ticketNumber){
        setTicketNumber(ticketNumber);
        setGarageName(garageName);
    }
    
    public Ticket(){
    }

    public final String getGarageName() {
        if (garageName == null || garageName.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        return garageName;
    }

    public final void setGarageName(String garageName) {
        if (garageName == null || garageName.isEmpty()){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.garageName = garageName;
    }

    public final int getTicketNumber() {
        if (ticketNumber <= 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return ticketNumber;
    }

    public final void setTicketNumber(int ticketNumber) {
        if (ticketNumber <= 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.ticketNumber = ticketNumber;
    }

    public final double getHoursParked() {
        return hoursParked;
    }

    public final void setHoursParked(double hoursParked) {
        if (hoursParked < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            this.hoursParked = hoursParked;
        }
    }

    public final double getFee() {
        if (fee < 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return fee;
    }

    public final void setFee(double fee) {
        if (fee < 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.fee = fee;
    }    
}
