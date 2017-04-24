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
public class Receipt {
    private final String EXCEPTION = "Problem with Receipt";
    private Ticket ticket;
    
    public Receipt() {
    }
    
    public Receipt(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.ticket = ticket;
    }
    
    
}
