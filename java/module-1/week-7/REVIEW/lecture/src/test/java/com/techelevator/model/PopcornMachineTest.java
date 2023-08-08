package com.techelevator.model;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PopcornMachineTest {

    private static final double DELTA = 1e-15;

    @Test
    public void getCreditRemaining() {
        // TODO : Objective 1 : Arrange vs. Act vs. Assert

        //Arrange
        PopcornMachine machine = new PopcornMachine(10,7,5);

        //Act
        BigDecimal credit = machine.getCreditRemaining();

        //Assert
        Assert.assertEquals(BigDecimal.ZERO, credit);
    }

    @Test
    public void getPopcornServingsRemaining() {
        //Arrange & Act
        PopcornMachine machine = new PopcornMachine(10,7,5);

        //Assert
        Assert.assertEquals(10, machine.getPopcornServingsRemaining());
    }

    @Test
    public void getSaltServingsRemaining() {
        //Arrange & Act
        PopcornMachine machine = new PopcornMachine(10,7,5);

        //Assert
        Assert.assertEquals(7, machine.getSaltServingsRemaining());
    }

    @Test
    public void getButterServingsRemaining() {
        //Arrange & Act
        PopcornMachine machine = new PopcornMachine(10,7,5);

        //Assert
        Assert.assertEquals(5, machine.getButterServingsRemaining());
    }

    @Test
    public void addMoney() {
        //Arrange
        PopcornMachine machine = new PopcornMachine(10,7,5);

        //Act
        machine.addMoney(new BigDecimal("10.75"));

        //Assert
        Assert.assertEquals(new BigDecimal("10.75"), machine.getCreditRemaining());

        //Act
        machine.addMoney(new BigDecimal("11.00"));

        //Assert
        Assert.assertEquals(new BigDecimal("21.75"), machine.getCreditRemaining());

        //Act
        machine.addMoney(new BigDecimal("0.25"));

        //Assert
        Assert.assertEquals(new BigDecimal("22.00"), machine.getCreditRemaining());
    }

    // TODO : TDD : Write tests for getChange then complete the code
    @Test
    public void getChange() {
        //Arrange
        PopcornMachine machine = new PopcornMachine(10,7,5);

        //Act & Assert
        // TODO : TDD : As a user, I expect the the newly created machine will not contain any change
        // TODO : TDD : As a user, I expect the that if I add money then I can get the same amount back as change
        // TODO : TDD : As a user, I expect the that if I add money then purchase popcorn, I will get the correct change

    }

    @Test
    public void buyPopcorn() {
        //Arrange
        PopcornMachine machine = new PopcornMachine(10,7,5);
        machine.addMoney(new BigDecimal("10.00"));
        Order order = new Order(Popcorn.LARGE_BUCKET, true, true);
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        //Act
        // TODO : Objective 1 : What if we pass more than one order?  What should the result be?
        // TODO : What if buyPopcorn returned a Popcorn array?
        // TODO : Objective 3 : What if buyPopcorn can throw exceptions?  How do we test that?
        machine.buyPopcorn(orders);

        //Assert
        // TODO : Objective 1 : We can assert that the remaining credit and servings but
        //  how can we assert that the correct popcorn order was processed?

        Assert.assertEquals(8, machine.getPopcornServingsRemaining());
        Assert.assertEquals(5, machine.getSaltServingsRemaining());
        Assert.assertEquals(3, machine.getButterServingsRemaining());
        // TODO : TDD : Check getChange after completing the code
        // TODO : Objective 1 : What is DELTA and why is it required?
        //Assert.assertEquals(4.50, machine.getChange(), DELTA);
    }
}