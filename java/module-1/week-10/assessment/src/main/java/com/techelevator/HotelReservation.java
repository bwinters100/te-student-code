package com.techelevator;

public class HotelReservation {
    /*
    Fill in the class details here...
     */
    private String name;
    private int numberOfNights;
    private int nightlyRate;
    private int estimatedTotal;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public int getEstimatedTotal() {
        return estimatedTotal = numberOfNights * nightlyRate;
    }

    public HotelReservation(String name, int numberOfNights, int nightlyRate){
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
        estimatedTotal = numberOfNights * nightlyRate;
    }
    public int getActualTotal(boolean requiresCleaning, boolean usedMinibar){
        int cleaningFee = 0;
        int miniBarFee = 0;
        if(requiresCleaning){
            cleaningFee += 25;
            estimatedTotal = estimatedTotal + cleaningFee;
        }
        if(usedMinibar){
            miniBarFee += 15;
            estimatedTotal = estimatedTotal + miniBarFee + (cleaningFee);
        }
        return estimatedTotal;
    }

    @Override
    public String toString() {
        return name + ":" + estimatedTotal;
    }
}
