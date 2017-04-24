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
        Vehicle vehicle = new Vehicle();
        OutputStrategy output = new GuiOutput();
        TicketFormatStrategy format = new ElectronicDisplayTicketFormat();
        TicketFormatStrategy ticketFormat = new BasicTicketFormat();
        testReceiptFormatStrategy receiptFormat = new testBasicReceiptFormat();
        ManagementTicketFormat management = new ManagementTicketFormat();
        TicketStorage storage = new TicketStorage();
        FeeCalculatorStrategy calc = new testMinMaxFeeCalculator();
        
        CheckinTerminal ct = new CheckinTerminal(garage, output, ticketFormat);
//        ORIGINAL_CHECKOUTTERMINAL checkout = new ORIGINAL_CHECKOUTTERMINAL(garage, output, storage, calc, receiptFormat, management);
        CheckoutTerminal checkout = new CheckoutTerminal(garage, output, storage, calc, receiptFormat, format, management);
        
        ct.printNewTicket();
        checkout.checkoutTicket(1);
        
        ct.printNewTicket();
        checkout.checkoutTicket(2);
        
        ct.printNewTicket();
        checkout.checkoutTicket(3);
        
        
    }
}
