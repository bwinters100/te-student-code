package com.techelevator.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PopcornTest {

    @Test
    public void getSize() {
        //Arrange
        Popcorn popcornSmall = new Popcorn(Popcorn.SMALL_BUCKET, true, true);
        Popcorn popcornLarge = new Popcorn(Popcorn.LARGE_BUCKET, true, true);

        //Act & Assert
        Assert.assertEquals(Popcorn.SMALL_BUCKET, popcornSmall.getSize());
        Assert.assertEquals(Popcorn.LARGE_BUCKET, popcornLarge.getSize());
    }

    @Test
    public void isSalted() {
        //Arrange
        Popcorn popcornSalted = new Popcorn(Popcorn.SMALL_BUCKET, true, true);
        Popcorn popcornNotSalted = new Popcorn(Popcorn.LARGE_BUCKET, false, true);

        //Act & Assert
        assertTrue(popcornSalted.isSalted());
        assertFalse(popcornNotSalted.isSalted());
    }

    @Test
    public void isButtered() {
        //Arrange
        Popcorn popcornButtered = new Popcorn(Popcorn.SMALL_BUCKET, true, true);
        Popcorn popcornNotButtered = new Popcorn(Popcorn.LARGE_BUCKET, true, false);

        //Act & Assert
        assertTrue(popcornButtered.isButtered());
        assertFalse(popcornNotButtered.isButtered());
    }

    @Test
    public void equals() {
        //Arrange
        Popcorn popcorn1a = new Popcorn(Popcorn.SMALL_BUCKET, true, true);
        Popcorn popcorn1b = new Popcorn(Popcorn.SMALL_BUCKET, true, true);
        Popcorn popcorn1c = new Popcorn(Popcorn.SMALL_BUCKET, true, true);
        Popcorn popcorn2a = new Popcorn(Popcorn.LARGE_BUCKET, true, true);
        Popcorn popcorn2b = new Popcorn(Popcorn.LARGE_BUCKET, true, true);
        Popcorn popcorn3 = new Popcorn(Popcorn.SMALL_BUCKET, false, true);
        Popcorn popcorn4 = new Popcorn(Popcorn.SMALL_BUCKET, true, false);

        //Act & Assert
        Assert.assertEquals(popcorn1a, popcorn1a);
        Assert.assertEquals(popcorn1a, popcorn1b);
        Assert.assertEquals(popcorn1b, popcorn1a);
        Assert.assertEquals(popcorn1a, popcorn1c);
        Assert.assertEquals(popcorn1b, popcorn1c);
        Assert.assertEquals(popcorn2a, popcorn2b);
        Assert.assertNotEquals(popcorn1a, popcorn2a);
        Assert.assertNotEquals(popcorn1a, popcorn3);
        Assert.assertNotEquals(popcorn1a, popcorn4);
    }
}