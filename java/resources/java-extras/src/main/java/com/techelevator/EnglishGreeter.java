package com.techelevator;

public class EnglishGreeter implements Greeter{
    @Override
    public String getGreeting(String name) {
        return "Hello " + name + "!";
    }
}
