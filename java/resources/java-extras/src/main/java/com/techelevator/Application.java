package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public enum Language {ENGLISH, FRENCH, SPANISH}

    public enum TimeOfDay {MORNING, AFTERNOON, EVENING}

    private static final String[][] GREETINGS = {
            {"Good morning", "Hello",   "Good evening"},
            {"Salut",        "Bonjour", "Bonsoir"},
            {"Buenos días",  "Hola",    "Buenas noches"},
    };


    public static void main(String[] args) {

        Application application = new Application();
        application.run();
    }

    private void run() {
        List<Greeter> greeters = new ArrayList<>();
        greeters.add(new EnglishGreeter());
        greeters.add(new FrenchGreeter());
        greeters.add(new SpanishGreeter());
        greeters.add(getInformalGreeter());
        greeters.add(new Greeter() {
            @Override
            public String getGreeting(String name) {
                return "What's up " + name + "?";
            }
        });

        greeters.add(getLanguageSpecificGreeter2(Language.FRENCH, TimeOfDay.EVENING));
        greeters.add(getLanguageSpecificGreeter2(Language.SPANISH, TimeOfDay.MORNING));

        for (Greeter greeter : greeters) {
            System.out.println(greeter.getGreeting("Jessy"));
        }
    }





    private Greeter getInformalGreeter() {
        // Anonymous class
        return new Greeter() {
            @Override
            public String getGreeting(String name) {
                return "Hey " + name + "!!!";
            }
        };
    }

    // Anonymous class with switch statements
    private Greeter getLanguageSpecificGreeter(Language language, TimeOfDay timeOfDay) {
        Greeter greeter = new Greeter() {
            @Override
            public String getGreeting(String name) {
                String greeting = "";

                switch (language) {
                    case ENGLISH:
                        switch (timeOfDay) {
                            case MORNING:
                                greeting = "Good morning";
                                break;
                            case AFTERNOON:
                                greeting = "Hello";
                                break;
                            case EVENING:
                                greeting = "Good evening";
                                break;
                        }
                        break;
                    case FRENCH:
                        switch (timeOfDay) {
                            case MORNING:
                                greeting = "Salut";
                                break;
                            case AFTERNOON:
                                greeting = "Bonjour";
                                break;
                            case EVENING:
                                greeting = "Bonsoir";
                                break;
                        }
                        break;
                    case SPANISH:
                        switch (timeOfDay) {
                            case MORNING:
                                greeting = "Buenos días";
                                break;
                            case AFTERNOON:
                                greeting = "Hola";
                                break;
                            case EVENING:
                                greeting = "Buenas noches";
                                break;
                        }
                        break;
//                    default:
//                        greeting = "Default greeting";
//                        break;
                }
                return greeting + " " + name + ".";
            }
        };
        return greeter;
    }

    // Anonymous class with 2 dimensional array
    private Greeter getLanguageSpecificGreeter2(Language language, TimeOfDay timeOfDay) {
        Greeter greeter = new Greeter() {
            @Override
            public String getGreeting(String name) {
                return GREETINGS[language.ordinal()][timeOfDay.ordinal()] + " " + name + ".";
            }
        };
        return greeter;
    }
}
