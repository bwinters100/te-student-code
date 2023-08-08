package com.techelevator.model;

public class Order {
    private final int size;
    private final boolean salted;
    private final boolean buttered;


    // ----- Constructors -----------------------------------------------------

    public Order(int size, boolean salted, boolean buttered) {
        this.size = size;
        this.salted = salted;
        this.buttered = buttered;
    }


    // ----- Accessors --------------------------------------------------------

    public int getSize() {
        return size;
    }

    public boolean isSalted() {
        return salted;
    }

    public boolean isButtered() {
        return buttered;
    }
}
