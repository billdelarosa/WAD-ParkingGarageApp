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
public class ManagementTicketFormat implements ManagementTicketStrategy {
    private final String EXCEPTION = "Error with Management Ticket Format";

    @Override
    public final String formatTicket(CheckoutTerminal checkout) {
        if (checkout == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            StringBuilder string;
            string = new StringBuilder("Bill's Garage Management");
            string.append("\n");
            string.append("Total fees collected: ").append(checkout.getDailyFeesCharged());
            string.append("\n");
            string.append("Total hours clocked: ").append(checkout.getDailyHoursParked());
            string.append("\n");
            string.append("Total cars parked: ").append(checkout.getCarCount());
            String managementString = string.toString();
            return managementString;
        }
    }

}
