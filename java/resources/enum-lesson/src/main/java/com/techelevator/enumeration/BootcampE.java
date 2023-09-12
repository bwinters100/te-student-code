package com.techelevator.enumeration;

import java.util.Locale;

/**
 * Bootcamp class using enums.
 */
public class BootcampE {

    public enum Campus {
        CLE,
        CBUS,
        CINCY,
        PGH,
        PHL,
        WILM;
    }

    public enum Season {
        SPRING,
        SUMMER,
        FALL;
    }

    public enum Platform {
        JAVA,
        DOT_NET;
    }


    // Member variables
    private final Campus campus;
    private final Season season;
    private final Platform platform;

    // Constructor
    public BootcampE(Campus campus, Season season, Platform platform) {
        this.campus = campus;
        this.season = season;
        this.platform = platform;
    }

    // getters
    public Campus getCampus() {
        return campus;
    }

    public Season getSeason() {
        return season;
    }

    public Platform getPlatform() {
        return platform;
    }

    // overrides
    @Override
    public String toString() {
        return "Bootcamp{" +
                "campus=" + campus +
                ", season=" + season +
                ", platform=" + platform +
                '}';
    }
}
