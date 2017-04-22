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
public class ReceiptTicketFormat implements TicketFormatStrategy {
    private final String EXCEPTION = "Error with Receipt Format";
    
    @Override
    public final String formatTicket(Ticket ticket) throws IllegalArgumentException {
        if (ticket == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {

            StringBuilder string;
            string = new StringBuilder("Thank you for coming to " + ticket.getGarageName());
            string.append("\n");
            string.append("Ticket Number: ").append(ticket.getTicketNumber());
            string.append("\n");
            string.append("Hours parked: ").append(ticket.getHoursParked());
            string.append("\n");
            string.append("Total: ").append(ticket.getFee());
            String receiptString = string.toString();
            return receiptString;
        }
    }
}
