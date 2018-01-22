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
    private int minHours;
    private double minFee;
    private double hourlyFee;
    private double totalFee;
    
    public MinNoMaxFeeCalculator() {
        setMinHours(2);
        setMinFee(1.5);
        setHourlyFee(0.75);
    }
    
    public MinNoMaxFeeCalculator(int minHours, double minFee, double hourlyFee) {
        setMinHours(minHours);
        setMinFee(minFee);
        setHourlyFee(hourlyFee);
    }
    
    public final double getFee(double hoursParked) {
        if (hoursParked < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            hoursParked = Math.ceil(hoursParked);
            if (hoursParked <= minHours) {
                totalFee = minFee;
            } else if (hoursParked > minHours) {
                totalFee = minFee + ((hoursParked - minHours) * hourlyFee);
            }
            return totalFee;
        }
    }

    public final void setFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            fee = totalFee;
        }
    }

    public int getMinHours() {
        return minHours;
    }

    public void setMinHours(int minHours) {
        if (minHours < 1) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.minHours = minHours;
    }

    public double getMinFee() {
        return minFee;
    }

    public void setMinFee(double minFee) {
        if (minFee < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.minFee = minFee;
    }

    public double getHourlyFee() {
        return hourlyFee;
    }

    public void setHourlyFee(double hourlyFee) {
        if (hourlyFee < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.hourlyFee = hourlyFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        if (totalFee < 0 || totalFee < minFee) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.totalFee = totalFee;
    }

    
}