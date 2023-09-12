package com.techelevator.enumeration;

/**
 * Bootcamp class using enums.
 */
public class BootcampEV2 {

    public enum Campus {
        CLE("Cleveland"),
        CBUS("Columbus"),
        CINCY("Cincinnati"),
        PGH( "Pittsburgh"),
        PHL("Philadelphia"),
        WILM("Wilmington");

        private final String str;

        private Campus(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    public enum Season {
        SPRING,
        SUMMER,
        FALL;

        @Override
        public String toString() {
            return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
        }
    }

    public enum Platform {
        JAVA("Java"),
        DOT_NET(".Net");

        private final String str;

        private Platform(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    // Member variables
    private final Campus campus;
    private final Season season;
    private final Platform platform;

    // Constructor
    public BootcampEV2(Campus campus, Season season, Platform platform) {
        this.campus = campus;
        this.season = season;
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "campus=" + campus +
                ", season=" + season +
                ", platform=" + platform +
                '}';
    }

    public Campus getCampus() {
        return campus;
    }

    public Season getSeason() {
        return season;
    }

    public Platform getPlatform() {
        return platform;
    }
}
