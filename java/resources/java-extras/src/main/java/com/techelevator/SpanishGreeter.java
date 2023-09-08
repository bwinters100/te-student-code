package com.techelevator;

public class SpanishGreeter implements Greeter{
    @Override
    public String getGreeting(String name) {
        return "Hola " + name + "!";
    }
}
