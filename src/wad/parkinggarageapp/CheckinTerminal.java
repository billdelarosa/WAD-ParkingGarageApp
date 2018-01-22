/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.parkinggarageapp;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Billy-Mac
 */
public class CheckinTerminal {
    private final String EXCEPTION = "Error with Check-in Terminal";
    private Garage garage;
    private Ticket ticket;
    private OutputStrategy output;
    private int ticketNumber;
    private TicketStorage ticketStorage;
    private TicketFormatStrategy format;
    
    public CheckinTerminal(Garage garage, OutputStrategy output, TicketFormatStrategy format) {
        if (garage == null || output == null || format == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.format = format;
        this.garage = garage;
        this.output = output;
    }
    
    public final void printNewTicket() {
        // STORE LOCALDATETIME.NOW(); IN LOCAL VARIABLE -> PASS TO TICKET CONSTRUCTOR
        
        
        ticketStorage = new TicketStorage();
        ticketNumber += 1; 
        ticket = new Ticket(garage.getGarageName(), ticketNumber);
        ticketStorage.addTicketToStorage(ticket);
        output.getOutput(format.formatTicket(ticket));
    }
    
    public final void setTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            this.ticket = ticket;
        }
    }
    
    public final Ticket getTicket() {
        return this.ticket;
    }

    public final TicketStorage getStorage() {
        return ticketStorage;
    }

    public final void setStorage(TicketStorage storage) {
        if (storage == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            this.ticketStorage = storage;
        }
    }

    public final int getTicketNumber() {
        return ticketNumber;
    }

    public final void setTicketNumber(int ticketNumber) {
        if (ticketNumber <= 0 || ticketStorage.findTicketByTicketNumber(ticketNumber) == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            this.ticketNumber = ticketNumber;
        }
    }

    public final Garage getGarage() {
        return garage;
    }

    public final void setGarage(Garage garage) {
        if (garage == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            this.garage = garage;
        }
    }
    
    public final void setOutput(OutputStrategy output){
        if (output == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.output = output;
    }
    
    public final OutputStrategy getOutput(){
        return output;
    }


    public final TicketStorage getTicketStorage() {
        return ticketStorage;
    }

    public final void setTicketStorage(TicketStorage ticketStorage) {
        if (ticketStorage == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.ticketStorage = ticketStorage;
    }

    public TicketFormatStrategy getFormat() {
        return format;
    }

    public void setFormat(TicketFormatStrategy format) {
        if (format == null) { 
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.format = format;
    }
    
    

    @Override
    public String toString() {
        return "CheckinTerminal{" + "garage=" + garage + ", ticket=" + ticket + 
                ", output=" + output + ", ticketNumber=" + ticketNumber 
                + ", ticketStorage=" + ticketStorage + ", format=" + format;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.garage);
        hash = 79 * hash + Objects.hashCode(this.ticket);
        hash = 79 * hash + this.ticketNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CheckinTerminal other = (CheckinTerminal) obj;
        if (this.ticketNumber != other.ticketNumber) {
            return false;
        }
        if (!Objects.equals(this.garage, other.garage)) {
            return false;
        }
        if (!Objects.equals(this.ticket, other.ticket)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
