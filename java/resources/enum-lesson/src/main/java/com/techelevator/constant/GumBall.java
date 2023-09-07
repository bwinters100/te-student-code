package com.techelevator.constant;

import java.util.Collection;
import java.util.Objects;

public class GumBall {

    public static final int COLOR_RED = 0;
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_GREEN = 2;
    public static final int NUMBER_OF_COLORS = 3;

    public static final String[] COLORS = {"Red", "Blue", "Green"};

    public static final int FLAVOR_MANGO = 0;
    public static final int FLAVOR_CHERRY = 1;
    public static final int FLAVOR_LIME = 2;
    public static final int FLAVOR_WATERMELON = 3;
    public static final int FLAVOR_LEMON = 4;
    public static final int NUMBER_OF_FLAVORS = 5;

    public static final String[] FLAVORS = {"Mango", "Cherry", "Lime", "Watermelon", "Lemon"};

    private final int color;
    private final int flavor;

    public GumBall(int color, int flavor) {
        this.color = color;
        this.flavor = flavor;
    }

    public int getColor() {
        return color;
    }

    public int getFlavor() {
        return flavor;
    }

    public static void fillContainer(Collection<GumBall> container, int max) {
        for (int i = container.size(); i < max; i++) {
            int color = (int) (Math.random() * NUMBER_OF_COLORS);
            int flavor = (int) (Math.random() * NUMBER_OF_FLAVORS);

            GumBall gumBall = new GumBall(color, flavor);
            container.add(gumBall);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GumBall gumBall = (GumBall) o;
        return color == gumBall.color && flavor == gumBall.flavor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, flavor);
    }

    @Override
    public String toString() {
        return "{" +
                "color=" + GumBall.COLORS[getColor()] +
                ", flavor=" + GumBall.FLAVORS[getFlavor()] +
                '}';
    }
}

