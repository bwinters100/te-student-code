package com.techelevator.model;

import java.math.BigDecimal;
import java.util.List;

public class PopcornMachine {

    private static final BigDecimal LARGE_BUCKET_COST = new BigDecimal("5.00");
    private static final BigDecimal SMALL_BUCKET_COST = new BigDecimal("3.50");
    private static final BigDecimal BUTTER_COST = new BigDecimal("0.50");


    private BigDecimal creditRemaining = BigDecimal.ZERO;
    private int popcornServingsRemaining;
    private int saltServingsRemaining;
    private int butterServingsRemaining;


    // ----- Constructors -----------------------------------------------------

    public PopcornMachine(int popcornServings, int saltServings, int butterServings) {
        this.popcornServingsRemaining = popcornServings;
        this.saltServingsRemaining = saltServings;
        this.butterServingsRemaining = butterServings;
    }


    // ----- Accessors --------------------------------------------------------

    public BigDecimal getCreditRemaining() {
        return creditRemaining;
    }

    public int getPopcornServingsRemaining() {
        return popcornServingsRemaining;
    }

    public int getSaltServingsRemaining() {
        return saltServingsRemaining;
    }

    public int getButterServingsRemaining() {
        return butterServingsRemaining;
    }


    // ----- PopcornMachine ---------------------------------------------------

    public void addMoney(BigDecimal money) {
        creditRemaining = creditRemaining.add(money);
    }

    // TODO : TDD : Complete getChange after writing the tests
    public double getChange() {
        return 0.00;
    }

    // TODO : Objective 1 : How can we make this method more testable?
    public void buyPopcorn(List<Order> orders) {

        // TODO : Objective 1 : what are some edge cases that we should code and test for?
        // TODO : What happens if a runtime exception is thrown from this code?
        // TODO: Can we use a custom exception?

        for (Order order : orders) {
            int size = order.getSize();
            boolean salted = order.isSalted();
            boolean buttered = order.isButtered();

            deductRemainingCredit(size, buttered);
            consumeRemainingServings(size, salted, buttered);
            Popcorn popcorn = new Popcorn(size, salted, buttered);

            System.out.println("You bought a " + popcorn + ".  ENJOY!!!!");
        }
    }


    // ----- private methods --------------------------------------------------

    private void deductRemainingCredit(int size, boolean buttered) {
        BigDecimal cost = size == Popcorn.SMALL_BUCKET ? SMALL_BUCKET_COST : LARGE_BUCKET_COST;
        if (buttered) {
            cost = cost.add(BUTTER_COST);
        }
        creditRemaining = creditRemaining.subtract(cost);
    }

    private void consumeRemainingServings(int size, boolean salted, boolean buttered) {
        int servings = (size == Popcorn.SMALL_BUCKET) ? 1 : 2;
        popcornServingsRemaining -= servings;
        saltServingsRemaining -= salted ? servings : 0;
        butterServingsRemaining -= buttered ? servings : 0;
    }
}