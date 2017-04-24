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
public class ElectronicDisplayTicketFormat implements TicketFormatStrategy {
    private final String EXCEPTION = "Error with Receipt Format";
    
    @Override
    public final String formatTicket(Ticket ticket) throws IllegalArgumentException {
        if (ticket == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {

            StringBuilder string;
            string = new StringBuilder("----------Electronic Display----------");
            string.append("\n");
            string.append("Hours Parked: ").append(ticket.getHoursParked());
            string.append("\n");
            string.append("Fee owed: $").append(ticket.getFee());
            string.append("\n");
            string.append("----------------------------------");
            String electronicDisplayString = string.toString();
            return electronicDisplayString;
        }
    }
}
