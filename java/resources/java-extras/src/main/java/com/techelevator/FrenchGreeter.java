package com.techelevator;

public class FrenchGreeter implements Greeter{
    @Override
    public String getGreeting(String name) {
        return "Bonjour " + name + "!";
    }
}
