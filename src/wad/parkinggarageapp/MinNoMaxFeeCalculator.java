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
public class MinNoMaxFeeCalculator implements FeeCalculatorStrategy {
    private final String EXCEPTION = "Error with Min No Max Fee Calculator";
    private final int MIN_HOURS = 2;
    private final double MIN_FEE = 1.5;
    private final double HOURLY_FEE = 0.75;
    private double fee;
    
    public final double getFee(double hoursParked) {
        if (hoursParked < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            hoursParked = Math.ceil(hoursParked);
            if (hoursParked <= MIN_HOURS) {
                fee = MIN_FEE;
            } else if (hoursParked > MIN_HOURS) {
                fee = MIN_FEE + ((hoursParked - MIN_HOURS) * HOURLY_FEE);
            }
            return fee;
        }
    }

    public final void setFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            this.fee = fee;
        }
    }
}
