package com.techelevator;

import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;
    private String name;
    private boolean open;
    private int numberOfCompactSlots;
    private int numberOfMidsizeSlots;
    private int numberOfFullsizeSlots;
    private List<Car> compactParkedCars = new ArrayList<>();
    private List<Car> midsizeParkedCars = new ArrayList<>();
    private List<Car> fullsizeParkedCars = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }

    public int getNumberOfCompactSlots() {
        return numberOfCompactSlots;
    }

    public int getNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getNumberOfFullsizeSlots() {
        return numberOfFullsizeSlots;
    }
    /*
    Fill in the class details here...
     */

    public ParkingLot(String name) {
        this.name = name;
        this.open = false;
        this.numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
        this.numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
        this.numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;

    }

    public ParkingLot(String name, boolean open) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
        this.numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
        this.numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
    }

    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullSizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullSizeSlots;
    }

    public int getLotSize() {
        return numberOfCompactSlots + numberOfMidsizeSlots + numberOfFullsizeSlots;
    }

    public int numberOfAvailableSlots(String carType) {
        int availableSlots = 0;
        if (carType.equals(Car.COMPACT)) {
            availableSlots = numberOfCompactSlots - compactParkedCars.size();
        } else if (carType.equals(Car.MIDSIZE)) {
            availableSlots = numberOfMidsizeSlots - midsizeParkedCars.size();
        } else if (carType.equals(Car.FULL_SIZE)) {
            availableSlots = numberOfFullsizeSlots - fullsizeParkedCars.size();
        }
        return availableSlots;
    }

    public boolean park(Car car) {
        int availableSpots = numberOfAvailableSlots(car.getType());
        if (availableSpots > 0) {
            if (car.getType().equals(Car.COMPACT)) {
                compactParkedCars.add(car);
            } else if (car.getType().equals(Car.MIDSIZE)) {
                midsizeParkedCars.add(car);
            } else if (car.getType().equals(Car.FULL_SIZE)) {
                fullsizeParkedCars.add(car);
            }
            return true;
        }
        return false;

    }


    public Car exit(String carType, String License) {
        Car toLeaveSpot = null;
        if (carType.equals(Car.COMPACT)) {
            for (Car car : compactParkedCars) {
                if (car.getLicense().equals(License)) {
                    toLeaveSpot = car;
                }

            }
            if (toLeaveSpot != null) {
                compactParkedCars.remove(toLeaveSpot);
            }

        } else if (carType.equals(Car.MIDSIZE)) {
            for (Car car : midsizeParkedCars) {
                if (car.getLicense().equals(License)) {
                    toLeaveSpot = car;
                }

            }
            if (toLeaveSpot != null) {
                midsizeParkedCars.remove(toLeaveSpot);
            }

        } else if (carType.equals(Car.FULL_SIZE)) {
            for (Car car : fullsizeParkedCars) {
                if (car.getLicense().equals(License)) {
                    toLeaveSpot = car;
                }

            }
            if (toLeaveSpot != null) {
                fullsizeParkedCars.remove(toLeaveSpot);
            }

        }
       return toLeaveSpot;

    }

}

