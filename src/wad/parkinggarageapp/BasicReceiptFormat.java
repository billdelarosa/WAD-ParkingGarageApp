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
public class BasicReceiptFormat implements ReceiptFormatStrategy {

    private final String EXCEPTION = "Error with Receipt Format";
    
    @Override
    public final String formatReceipt(Receipt receipt) throws IllegalArgumentException {
        if (receipt == null) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {

            StringBuilder string;
           
            string = new StringBuilder("Thank you for coming to " + receipt.getTicket().getGarageName());
            string.append("\n");
            string.append("---------------------------------");
            string.append("\n");
            string.append("*** Receipt ***");
            string.append("\n");
            string.append("---------------------------------");
            string.append("\n");
            string.append("Ticket Number: ").append(receipt.getTicket().getTicketNumber());
            string.append("\n");
            string.append("Hours parked: ").append(receipt.getTicket().getHoursParked());
            string.append("\n");
            string.append("Total: $").append(receipt.getTicket().getFee());
            string.append("\n");
            string.append("---------------------------------");
            String receiptString = string.toString();
            return receiptString;
        }
    }
}
