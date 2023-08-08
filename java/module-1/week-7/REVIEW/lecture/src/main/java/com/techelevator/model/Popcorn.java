package com.techelevator.model;

import java.util.Objects;

public class Popcorn {

    public static final int SMALL_BUCKET = 0;
    public static final int LARGE_BUCKET = 1;

    private static final String[] SIZES = {"small bucket", "large bucket"};


    private final int size;
    private final boolean salted;
    private final boolean buttered;


    // ----- Constructors -----------------------------------------------------

    public Popcorn(int size, boolean salted, boolean buttered) {
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


    // ----- Object overrides -------------------------------------------------

    @Override
    public String toString() {
        return SIZES[size] + " of" +
                ( salted ? " salted" : "" )+
                ( buttered ? " buttered" : "" )+
                " popcorn";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Popcorn popcorn = (Popcorn) o;
        return size == popcorn.size && salted == popcorn.salted && buttered == popcorn.buttered;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, salted, buttered);
    }
}
