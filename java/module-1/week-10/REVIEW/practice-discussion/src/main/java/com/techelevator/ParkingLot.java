package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;

    /*
    Fill in the class details here...
     */


    private String name;
    private boolean open;
    private int numberOfCompactSlots;
    private int numberOfMidsizeSlots;
    private int numberOfFullsizeSlots;

    private List<Car> compactParkedCars = new ArrayList<>();
    private List<Car> midsizeParkedCars = new ArrayList<>();
    private List<Car> fullsizeParkedCars = new ArrayList<>();


    public ParkingLot(String name) {
//        this.name = name;
//
//        this.open = false;
//
//        this.numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
//        this.numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
//        this.numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;
        this(name, false);
    }

    public ParkingLot(String name, boolean open) {
//        this.name = name;
//        this.open = open;
//
//        this.numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
//        this.numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
//        this.numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;

        this(name, open, DEFAULT_NUMBER_OF_COMPACT_SLOTS, DEFAULT_NUMBER_OF_MIDSIZE_SLOTS, DEFAULT_NUMBER_OF_FULLSIZE_SLOTS);
    }

    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullsizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullsizeSlots;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
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
        String carType = car.getType();
        int availableSpots = numberOfAvailableSlots(carType);

        if (availableSpots > 0) {
            if (carType.equals(Car.COMPACT)) {
                compactParkedCars.add(car);
            } else if (carType.equals(Car.MIDSIZE)) {
                midsizeParkedCars.add(car);
            } else if (carType.equals(Car.FULL_SIZE)) {
                fullsizeParkedCars.add(car);
            }
            return true;
        }
        return false;
    }

    public Car exit(String carType, String license) {

        if (carType.equals(Car.COMPACT)) {
            return unparkCar( license, compactParkedCars);
        }
        if (carType.equals(Car.MIDSIZE)) {
            return unparkCar(license, midsizeParkedCars);
        }
        if (carType.equals(Car.FULL_SIZE)) {
            return unparkCar( license, fullsizeParkedCars);
        }
        return null;
    }

    private Car unparkCar(String license, List<Car> parkedCars ) {
        Car unparkedCar = null;
        for( int i = 0; i < parkedCars.size() && unparkedCar == null; ++i ) {
            Car car = parkedCars.get(i);
            if (car.getLicense().equals(license)) {
                unparkedCar = car;
            }
        }
        if (unparkedCar != null) {
            parkedCars.remove(unparkedCar);
        }
        return unparkedCar;
    }




}
