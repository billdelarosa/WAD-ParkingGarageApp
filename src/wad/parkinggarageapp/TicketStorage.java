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
public class TicketStorage {
    private final String EXCEPTION = "Error with Ticket Storage";
    private Ticket ticket;
    private static Ticket[] ticketArray = new Ticket[3];  
    
    public final Ticket findTicketByTicketNumber(int ticketNumber){
        if (ticketNumber <= 0 || ticketNumber > 4){
            throw new IllegalArgumentException(EXCEPTION);
        }
        for (Ticket tempTicket : ticketArray){
            if (tempTicket.getTicketNumber() == ticketNumber){
                ticket = tempTicket;
            }
        }
        return ticket; 
    }
    
    public final void addTicketToStorage(Ticket ticket){
        if (ticket == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        for (int i = 0; i < ticketArray.length; i++){
            if (ticketArray[i] == null){
                ticketArray[i] = ticket;
            }
        }
    }

    public final Ticket getTicket() {
        return ticket;
    }

    public final void setTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.ticket = ticket;
    }

    public final static Ticket[] getTicketArray() {
        return ticketArray;
    }

    public final static void setTicketArray(Ticket[] ticketArray) {
        TicketStorage.ticketArray = ticketArray;
    }
    
    
}