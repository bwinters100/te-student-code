package com.techelevator.enumeration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BootcampETest {

    @Test
    void getCampus() {
        BootcampE bootcamp = new BootcampE(BootcampE.Campus.CBUS, BootcampE.Season.FALL, BootcampE.Platform.JAVA);
        assertEquals(BootcampE.Campus.CBUS, bootcamp.getCampus());
    }

    @Test
    void getSeason() {
        BootcampE bootcamp = new BootcampE(BootcampE.Campus.CBUS, BootcampE.Season.FALL, BootcampE.Platform.JAVA);
        assertEquals(BootcampE.Season.FALL, bootcamp.getSeason());
    }

    @Test
    void getPlatform() {
        BootcampE bootcamp = new BootcampE(BootcampE.Campus.CBUS, BootcampE.Season.FALL, BootcampE.Platform.JAVA);
        assertEquals(BootcampE.Platform.JAVA, bootcamp.getPlatform());
    }
}