package com.techelevator;

import com.techelevator.constant.Bootcamp;
import com.techelevator.constant.BootcampV2;
import com.techelevator.enumeration.BootcampE;
import com.techelevator.enumeration.BootcampEV2;
import com.techelevator.enumeration.Connection;
import com.techelevator.enumeration.Day;
import com.techelevator.enumeration.WeeklyAlarm;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public enum Planet {
        MERCURY, VENUS, EARTH, MARS, JUPITER,
        SATURN, URANUS, NEPTUNE
    }

    public enum Mood{ HAPPY, SAD }


    public static void main(String[] args) {

        // ***** Bootcamp with constants examples *****************************
        Bootcamp bootcamp1;
        Bootcamp bootcamp2;
        Bootcamp bootcamp3;

        // passing ints to constructor
//        bootcamp1 = new Bootcamp(0, 1,0);
//        bootcamp2 = new Bootcamp(1,1, 1);
//        bootcamp3 = new Bootcamp(1,0, 0);
//
//        System.out.println("bootcamp1 = " + bootcamp1);
//        System.out.println("bootcamp2 = " + bootcamp2);
//        System.out.println("bootcamp3 = " + bootcamp3);

        // passing constants to constructor
//        bootcamp1 = new Bootcamp(Bootcamp.CAMPUS_CBUS, Bootcamp.SEASON_FALL,Bootcamp.PLATFORM_JAVA);
//        bootcamp2 = new Bootcamp(Bootcamp.CAMPUS_PHL,Bootcamp.SEASON_SUMMER, Bootcamp.PLATFORM_DOT_NET);
//        bootcamp3 = new Bootcamp(Bootcamp.CAMPUS_WILM,Bootcamp.SEASON_SPRING, Bootcamp.PLATFORM_JAVA);
//
//        System.out.println("bootcamp1 = " + bootcamp1);
//        System.out.println("bootcamp2 = " + bootcamp2);
//        System.out.println("bootcamp3 = " + bootcamp3);
//
//        System.out.println(Bootcamp.CAMPUS_STRINGS[4]);
//        System.out.println(Bootcamp.CAMPUS_STRINGS[Bootcamp.CAMPUS_PHL]);
//
        // passing invalid parameters to constructor
//        bootcamp1 = new Bootcamp(99, 1,0);
//        System.out.println("bootcamp1 = " + bootcamp1);

        // Update to V2 !!!!
        BootcampV2 bootcamp1v2;
        BootcampV2 bootcamp2v2;
        BootcampV2 bootcamp3v2;

//        bootcamp1v2 = new BootcampV2(BootcampV2.CAMPUS_CBUS, BootcampV2.SEASON_FALL,BootcampV2.PLATFORM_JAVA);
//        bootcamp2v2 = new BootcampV2(BootcampV2.CAMPUS_PHL,BootcampV2.SEASON_SUMMER, BootcampV2.PLATFORM_DOT_NET);
//        bootcamp3v2 = new BootcampV2(BootcampV2.CAMPUS_WILM,BootcampV2.SEASON_SPRING, BootcampV2.PLATFORM_JAVA);
//
//        System.out.println("bootcamp1 = " + bootcamp1v2);
//        System.out.println("bootcamp2 = " + bootcamp2v2);
//        System.out.println("bootcamp3 = " + bootcamp3v2);

        // passing invalid parameters to constructor
     //   bootcamp1v2 = new BootcampV2(99, 1,0);

        // alter a value in the constant campus string array
//        bootcamp1v2 = new BootcampV2(BootcampV2.CAMPUS_CBUS, BootcampV2.SEASON_FALL, BootcampV2.PLATFORM_JAVA);
//        System.out.println("bootcamp1 = " + bootcamp1v2);
//        BootcampV2.CAMPUS_STRINGS[1] = "Kalamazoo";
//        System.out.println("bootcamp1 = " + bootcamp1v2);


        // ***** Bootcamp with enums ******************************************
        BootcampE bootcampE1;
        BootcampE bootcampE2;
        BootcampE bootcampE3;

//        bootcampE1 = new BootcampE(BootcampE.Campus.CBUS, BootcampE.Season.FALL, BootcampE.Platform.JAVA);
//        bootcampE2 = new BootcampE(BootcampE.Campus.PHL, BootcampE.Season.SUMMER, BootcampE.Platform.DOT_NET);
//        bootcampE3 = new BootcampE(BootcampE.Campus.WILM, BootcampE.Season.SPRING, BootcampE.Platform.JAVA);
//
//        System.out.println("bootcampE1 = " + bootcampE1);
//        System.out.println("bootcampE2 = " + bootcampE2);
//        System.out.println("bootcampE3 = " + bootcampE3);

        // type safety - constructor arguments must be the declared enum types (Campus, Season, Platform)
//        bootcampE1 = new BootcampE("CBUS", BootcampE.Season.FALL, BootcampE.Platform.JAVA);
//        bootcampE2 = new BootcampE("Philadelphia", BootcampE.Season.SUMMER, BootcampE.Platform.DOT_NET);
//        bootcampE3 = new BootcampE(1, 0, 99);


        // Update to V2 !!!!
        BootcampEV2 bootcampE1v2;
        BootcampEV2 bootcampE2v2;
        BootcampEV2 bootcampE3v2;

        bootcampE1v2 = new BootcampEV2(BootcampEV2.Campus.CBUS, BootcampEV2.Season.FALL, BootcampEV2.Platform.JAVA);
        bootcampE2v2 = new BootcampEV2(BootcampEV2.Campus.PHL, BootcampEV2.Season.SUMMER, BootcampEV2.Platform.DOT_NET);
        bootcampE3v2 = new BootcampEV2(BootcampEV2.Campus.WILM, BootcampEV2.Season.SPRING, BootcampEV2.Platform.JAVA);

        System.out.println("bootcampE1 = " + bootcampE1v2);
        System.out.println("bootcampE2 = " + bootcampE2v2);
        System.out.println("bootcampE3 = " + bootcampE3v2);



        Planet homePlanet = Planet.EARTH;
        Mood myMood = Mood.HAPPY;
//        System.out.println("I am very " + myMood + "!");

//        Connection conn1 = new Connection("CA", "123456");
//        System.out.println(conn1);
//        conn1.setStatus(Connection.Status.CONNECTED);
//        System.out.println(conn1);


        //=====================================================================
        //= Other Enum Stuff                                                  =
        //=====================================================================

        // ***** Day enum example *********************************************
        WeeklyAlarm alarm1 = new WeeklyAlarm(Day.TUESDAY);
        System.out.println("alarm1 = " + alarm1);
        alarm1.alarm();

        // declare, assign and print out Day variables
        Day day1 = Day.FRIDAY;
        Day day2 = Day.WEDNESDAY;
//        System.out.println("day1 = " + day1);
//        System.out.println("day2 = " + day2);

        // illegal enum assignments
//        Day day3 = 1;
//        Day day4 = "TUESDAY";

        // loop through the Day enum values
//        for (Day currentDay : Day.values()) {
//            System.out.println(currentDay + " order is " + currentDay.ordinal());
//        }

        // compare enums - comparable by the natural order
//        if (Day.MONDAY.compareTo(Day.FRIDAY) > 0) {
//            System.out.println("Monday is greater than Friday!");
//        } else if (Day.MONDAY.compareTo(Day.FRIDAY) < 0) {
//            System.out.println("Friday is greater than Monday!");
//        }

        // enums in a collection
//        List<Day> days = new ArrayList<>();
//        days.add(Day.TUESDAY);
//        days.add(Day.FRIDAY);
//        for (Day day : days) {
//            System.out.println(day);
//        }

        // enum in if statement
        Day day3 = Day.MONDAY;
        if (day3 == Day.MONDAY) {  // notice use of ==, not .equals()
            System.out.println("It's Monday!");
        } else {
            System.out.println("Not Monday!");
        }
        if (day3.equals(Day.MONDAY)) {  // notice use of .equals() not ==
            System.out.println("It's Monday!");
        } else {
            System.out.println("Not Monday!");
        }

    }
}
