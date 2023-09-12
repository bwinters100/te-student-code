package com.techelevator.constant;

/**
 * Bootcamp class using constants (no enums)
 */
public class Bootcamp {
    // Campus constants
    public static final int CAMPUS_CLE = 0;
    public static final int CAMPUS_CBUS = 1;
    public static final int CAMPUS_CINCY = 2;
    public static final int CAMPUS_PGH = 3;
    public static final int CAMPUS_PHL = 4;
    public static final int CAMPUS_WILM = 5;

    public static final String[] CAMPUS_STRINGS =
            {"Cleveland", "Columbus", "Cincinnati", "Pittsburgh", "Philadelphia", "Wilmington"};

    // Season constants
    public static final int SEASON_SPRING = 0;
    public static final int SEASON_SUMMER = 1;
    public static final int SEASON_FALL = 2;

    public static final String[] SEASON_STRINGS = {"Spring", "Summer", "Fall"};

    // Platform constants
    public static final int PLATFORM_JAVA = 0;
    public static final int PLATFORM_DOT_NET = 1;

    public static final String[] PLATFORM_STRINGS = {"Java", ".NET"};

    // Member variables
    private final int campus;
    private final int season;
    private final int platform;

    // Constructor
    public Bootcamp(int campus, int season, int platform) {
        this.campus = campus;
        this.season = season;
        this.platform = platform;
    }

    // getters
    public int getCampus() {
        return campus;
    }

    public int getSeason() {
        return season;
    }

    public int getPlatform() {
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
