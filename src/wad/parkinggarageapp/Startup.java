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
public class Startup {
    public static void main(String[] args) {
        Garage garage = new Garage("Bill's Garage");
        OutputStrategy output = new GuiOutput();
        TicketFormatStrategy receiptFormat = new ReceiptTicketFormat();
        TicketFormatStrategy ticketFormat = new BasicTicketFormat();
        ManagementTicketFormat management = new ManagementTicketFormat();
        TicketStorage storage = new TicketStorage();
        
        FeeCalculatorStrategy calc = new MinMaxFeeCalculator();
        
        CheckinTerminal ct = new CheckinTerminal(garage, output, ticketFormat);
        CheckoutTerminal checkout = new CheckoutTerminal(garage, output, storage, calc, receiptFormat, management);
        
        ct.printNewTicket();
        checkout.checkoutTicket(1);
        
        ct.printNewTicket();
        checkout.checkoutTicket(2);
        
        ct.printNewTicket();
        checkout.checkoutTicket(3);
        
        
    }
}
