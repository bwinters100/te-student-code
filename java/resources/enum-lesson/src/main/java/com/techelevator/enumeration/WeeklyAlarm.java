package com.techelevator.enumeration;

/**
 * Alarm that occurs once a week on the set day.
 */
public class WeeklyAlarm {

    private final Day day;

    public WeeklyAlarm(Day day) {
        this.day = day;
    }

    public void alarm() {
        System.out.println("WAKE UP, IT'S " + day + "!!!!!!!!!!!!!");
    }


    @Override
    public String toString() {
        return "WeeklyAlarm{" +
                "day=" + day +
                '}';
    }
}
