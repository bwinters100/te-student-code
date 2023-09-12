package com.techelevator.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BootcampTest {

    @Test
    void getCampus() {
        Bootcamp bootcamp = new Bootcamp(Bootcamp.CAMPUS_CBUS, Bootcamp.SEASON_FALL, Bootcamp.PLATFORM_JAVA);
        assertEquals(Bootcamp.CAMPUS_CBUS, bootcamp.getCampus());
    }

    @Test
    void getSeason() {
        Bootcamp bootcamp = new Bootcamp(Bootcamp.CAMPUS_CBUS, Bootcamp.SEASON_FALL, Bootcamp.PLATFORM_JAVA);
        assertEquals(Bootcamp.SEASON_FALL, bootcamp.getSeason());
    }

    @Test
    void getPlatform() {
        Bootcamp bootcamp = new Bootcamp(Bootcamp.CAMPUS_CBUS, Bootcamp.SEASON_FALL, Bootcamp.PLATFORM_JAVA);
        assertEquals(Bootcamp.PLATFORM_JAVA, bootcamp.getPlatform());
    }
}