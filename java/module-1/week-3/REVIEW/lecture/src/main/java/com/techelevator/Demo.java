package com.techelevator;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
//        List<String> names = new ArrayList<String>();
//        List<String> names = new LinkedList<>();
//        ArrayList<String> names = new ArrayList<>();
//        LinkedList<String> names = new LinkedList<>();

        names.add("Joe");
        names.add("Mary");
        names.add("Sam");
        names.add("Kim");

        // for-each loop
        for(String name : names) {
            System.out.println("Name: " + name);
        }

        System.out.println("=========================");

        // for loop with index
        for(int i = 0; i < names.size(); ++i) {
            System.out.println("Name " + i + ": " + names.get(i));
        }

        System.out.println("=========================");

        // Maps
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Joe", 22);
        ages.put("Mary", 18);
        ages.put("Sam", 21);
        ages.put("Kim", 24);

        // iterate keys
        for (String key: ages.keySet()) {
            System.out.println("Key: " + key);
        }

        System.out.println("=========================");

        // iterate entries
        for (Map.Entry<String, Integer> entry: ages.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        System.out.println("=========================");
        
    }
}
