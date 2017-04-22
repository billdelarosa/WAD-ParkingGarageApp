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
public class testMinMaxFeeCalculator implements FeeCalculatorStrategy {
    private final String EXCEPTION = "Error with Min Max Fee Calculator";
    private double minFee;
    private double maxFee;
    private double hourlyFee;
    private double minHours;
    private double maxHours;
    private double fee;

    public testMinMaxFeeCalculator() {
        setMinHours(3.0);
        setMaxHours(24.0);
        setMinFee(2.0);
        setMaxFee(10.0);
        setHourlyFee(0.5);
    }
    
    public testMinMaxFeeCalculator(double minHours, double maxHours, double minFee, double maxFee, double hourlyFee) {
        setMinHours(minHours);
        setMaxHours(maxHours);
        setMinFee(minFee);
        setMaxFee(maxFee);
        setHourlyFee(hourlyFee);
    }
    
    
    public final double getFee(double parkedHours) {
        if (parkedHours < 0 || parkedHours > maxHours){
            throw new IllegalArgumentException(EXCEPTION);
        } else {
            parkedHours = Math.ceil(parkedHours);
            if (parkedHours <= minHours){
                fee = minFee;
            } else if (parkedHours > minHours) {
                fee = minFee + ((parkedHours - minHours) * hourlyFee);
            } if (fee >= maxFee) {
                return maxFee;
            }
            return fee;
        }
    }

    public double getMinFee() {
        return minFee;
    }

    public void setMinFee(double minFee) {
        if (minFee < 0 || minFee > maxFee) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.minFee = minFee;
    }

    public double getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(double maxFee) {
        if (maxFee < 0 || maxFee < minFee) {
            throw new  IllegalArgumentException(EXCEPTION);
        }
        this.maxFee = maxFee;
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

    public double getMinHours() {
        return minHours;
    }

    public void setMinHours(double minHours) {
        if (minHours < 0 || minHours > maxHours) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.minHours = minHours;
    }

    public double getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(double maxHours) {
        if (maxHours < minHours) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        this.maxHours = maxHours;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException(EXCEPTION);
        } 
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "testMinMaxFeeCalculator{" + "minFee=" + minFee + ", maxFee=" 
                + maxFee + ", hourlyFee=" + hourlyFee + ", minHours=" + minHours 
                + ", maxHours=" + maxHours + ", fee=" + fee + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.minFee) ^ (Double.doubleToLongBits(this.minFee) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.maxFee) ^ (Double.doubleToLongBits(this.maxFee) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.hourlyFee) ^ (Double.doubleToLongBits(this.hourlyFee) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.minHours) ^ (Double.doubleToLongBits(this.minHours) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.maxHours) ^ (Double.doubleToLongBits(this.maxHours) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final testMinMaxFeeCalculator other = (testMinMaxFeeCalculator) obj;
        if (Double.doubleToLongBits(this.minFee) != Double.doubleToLongBits(other.minFee)) {
            return false;
        }
        if (Double.doubleToLongBits(this.maxFee) != Double.doubleToLongBits(other.maxFee)) {
            return false;
        }
        if (Double.doubleToLongBits(this.hourlyFee) != Double.doubleToLongBits(other.hourlyFee)) {
            return false;
        }
        if (Double.doubleToLongBits(this.minHours) != Double.doubleToLongBits(other.minHours)) {
            return false;
        }
        if (Double.doubleToLongBits(this.maxHours) != Double.doubleToLongBits(other.maxHours)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
}
