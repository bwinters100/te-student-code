package com.techelevator.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void getSize() {
        //Arrange
        Order orderLarge = new Order(Popcorn.LARGE_BUCKET, true, true);
        Order orderSmall = new Order(Popcorn.SMALL_BUCKET, true, true);

        //Act & Assert
        Assert.assertEquals(Popcorn.LARGE_BUCKET, orderLarge.getSize());
        Assert.assertEquals(Popcorn.SMALL_BUCKET, orderSmall.getSize());
    }

    @Test
    public void isSalted() {
        //Arrange
        Order orderSalted = new Order(Popcorn.LARGE_BUCKET, true, true);
        Order orderNotSalted = new Order(Popcorn.LARGE_BUCKET, false, true);

        //Act & Assert
        Assert.assertTrue(orderSalted.isSalted());
        Assert.assertFalse(orderNotSalted.isSalted());
    }

    @Test
    public void isButtered() {
        //Arrange
        Order orderButtered= new Order(Popcorn.LARGE_BUCKET, true, true);
        Order orderNotButtered = new Order(Popcorn.LARGE_BUCKET, true, false);

        //Act & Assert
        Assert.assertTrue(orderButtered.isButtered());
        Assert.assertFalse(orderNotButtered.isButtered());
    }
}