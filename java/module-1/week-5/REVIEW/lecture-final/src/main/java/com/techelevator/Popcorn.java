package com.techelevator;

public class Popcorn {

    public static final int AVG_KERNEL_WEIGHT = 5;

    private String flavor;
    private String brand;




//    private boolean buttered;
//    private boolean salted;


    public Popcorn() {
        flavor = "caramel";
        brand = "OR";
    }

    public Popcorn(String flavor, String brand) {
        this.flavor = flavor;
        this.brand = brand;
    }


    public boolean pop(boolean buttered) {

        int oilRequired = 10 * AVG_KERNEL_WEIGHT;

        return pop(buttered, true);
    }

    // must be unique signature
//    public boolean pop(boolean salted) {
//
//        return pop(true, salted);
//    }


    public boolean pop(boolean buttered, boolean salted) {
        System.out.println("You have some pop corn");
        if (buttered) {
            System.out.println("it is buttered");
        }
        if(salted) {
            System.out.println("it is salted");
        }
        return true;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getBrand() {
        return brand;
    }

//    public boolean isButtered() {
//        return buttered;
//    }
//
//    public boolean isSalted() {
//        return salted;
//    }


    @Override
    public String toString() {
        return "Popcorn{" +
                "flavor='" + flavor + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
