package wad.parkinggarageapp;

/**
 *
 * @author Billy-Mac
 */
public class BasicTicketFormat implements TicketFormatStrategy {

    private final String EXCEPTION = "Sorry Ticket Format Error";

    @Override
    public final String formatTicket(Ticket ticket) throws IllegalArgumentException {
        if (ticket == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {

            StringBuilder string;
            string = new StringBuilder("---------- Welcome to " + ticket.getGarageName() + "----------");
            string.append("\n");
            string.append("Ticket Number: ").append(ticket.getTicketNumber());
            string.append("\n");
            string.append("------------ Have a nice day! -------------- ");
            string.append("\n");
            String ticketString = string.toString();
            return ticketString;
        }
    }
    
    

}
