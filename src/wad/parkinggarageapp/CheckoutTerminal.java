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
public class CheckoutTerminal {
    private final String EXCEPTION = "Error with Checkout Terminal";
    private Garage garage;
    private Ticket ticket;
    private OutputStrategy output;
    private OutputStrategy managementOutput;
    private TicketStorage ticketStorage;
    private ManagementTicketFormat management;
    private FeeCalculatorStrategy feeCalc;
    private testReceiptFormatStrategy receiptFormat;
    private TicketFormatStrategy format;
    private Receipt receipt;
    private double dailyFeesCharged;
    private int dailyHoursParked;
    private int carCount;
    private int hoursParked;
    
    public CheckoutTerminal(Garage garage, 
                            OutputStrategy output, 
                            TicketStorage ticketStorage, 
                            FeeCalculatorStrategy feeCalc,
                            testReceiptFormatStrategy receiptFormat,
                            TicketFormatStrategy format,
                            ManagementTicketFormat management) {
        if (garage == null || output == null || ticketStorage == null || feeCalc == null || receiptFormat == null || format == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.management = management;
        this.format = format;
        this.receiptFormat = receiptFormat;
        this.garage = garage;
        this.output = output;
        this.ticketStorage = ticketStorage;
        this.feeCalc = feeCalc;
    }
    
    public final int getRandomNumberOfHoursParked(){
        return (int)(Math.random() * 24 + 1);
    }
    public final void checkoutTicket(int ticketNumber){
        ticket = ticketStorage.findTicketByTicketNumber(ticketNumber);
        ticket.setHoursParked(getRandomNumberOfHoursParked());
        ticket.setFee(feeCalc.getFee(ticket.getHoursParked()));
        
        receipt = new Receipt(ticket);
        String formatOutput = receiptFormat.formatReceipt(receipt);

//format.formatTicket(ticket);
        dailyHoursParked += ticket.getHoursParked();
        dailyFeesCharged += ticket.getFee();
        carCount += 1;
        printElectronicDisplay();
        output.getOutput(formatOutput);
        printManagementOutput();
    }

    private final void printElectronicDisplay(){
        format = new ElectronicDisplayTicketFormat();
        output.getOutput(format.formatTicket(ticket));
    }
    
    private final void printManagementOutput(){
        managementOutput = new ConsoleOutput();
        managementOutput.getOutput(management.formatTicket(this));
    }
    
    public final Garage getGarage() {
        if (garage == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return garage;
    }

    public final void setGarage(Garage garage) {
        if (garage == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.garage = garage;
    }

    public final Ticket getTicket() {
        if (ticket == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return ticket;
    }

    public final void setTicket(Ticket ticket) {
        if (ticket == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.ticket = ticket;
    }

    public final OutputStrategy getOutput() {
        if (output == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return output;
    }

    public final void setOutput(OutputStrategy output) {
        if (output == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.output = output;
    }

    public final TicketStorage getTicketStorage() {
        if (ticketStorage == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return ticketStorage;
    }

    public final void setTicketStorage(TicketStorage ticketStorage) {
        if (ticketStorage == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.ticketStorage = ticketStorage;
    }

    public final FeeCalculatorStrategy getFeeCalc() {
        if (feeCalc == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return feeCalc;
    }

    public final void setFeeCalc(FeeCalculatorStrategy feeCalc) {
        if (feeCalc == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.feeCalc = feeCalc;
    }

    public final TicketFormatStrategy getFormat() {
        if (format == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return format;
    }

    public final void setFormat(TicketFormatStrategy format) {
        if (format == null){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.format = format;
    }

    public final double getDailyFeesCharged() {
        if (dailyFeesCharged <= 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return dailyFeesCharged;
    }

    public final void setDailyFeesCharged(double dailyFeesCharged) {
        if (dailyFeesCharged <= 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.dailyFeesCharged = dailyFeesCharged;
    }

    public final int getDailyHoursParked() {
        if (dailyHoursParked <= 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return dailyHoursParked;
    }

    public final void setDailyHoursParked(int dailyHoursParked) {
        if (dailyHoursParked <= 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.dailyHoursParked = dailyHoursParked;
    }

    public final int getCarCount() {
        if (carCount <= 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        return carCount;
    }

    public final void setCarCount(int carCount) {
        if (carCount <= 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.carCount = carCount;
    }
    
    
    
    
}
