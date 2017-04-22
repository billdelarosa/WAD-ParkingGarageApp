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
public class MinMaxFeeCalculator implements FeeCalculatorStrategy {
    private final String EXCEPTION = "Error with Min Max Fee Calculator";
    private final double MIN_FEE = 2.0;
    private final double MAX_FEE = 10.0;
    private final double HOURLY_FEE = 0.5;
    private final double MIN_HOURS = 3.0;
    private final double MAX_HOURS = 24.0;
    private double fee;

    public final double getFee(double parkedHours) {
        if (parkedHours < 0 || parkedHours > MAX_HOURS){
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            parkedHours = Math.ceil(parkedHours);
            if (parkedHours <= MIN_HOURS){
                fee = MIN_FEE;
            } else if (parkedHours > MIN_HOURS) {
                fee = MIN_FEE + ((parkedHours - MIN_HOURS) * HOURLY_FEE);
            } if (fee >= MAX_FEE) {
                return MAX_FEE;
            }
            return fee;
        }
    }
    

    public final void setFee(double fee) {
        if (fee < 0){
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.fee = fee;
    }
    
    
    
    
}
