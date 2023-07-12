package com.techelevator;

import java.util.*;

public class Demo {

    public static void main(String[] args) {




        List<String> namesList = new ArrayList<>();
//        List<String> names = null;

        List<Integer> numbers;

//        List<String> names = new ArrayList<String>();
//        List<String> names = new LinkedList<>();
//        ArrayList<String> names = new ArrayList<>();
//        LinkedList<String> names = new LinkedList<>();

        namesList.add("Joe");
        namesList.add("Mary");
        namesList.add("Sam");
        namesList.add("Kim");
        namesList.add("Dan");

        String[] namesArray = new String[namesList.size()];
//        // copy from a List to an array
//        for (int i = 0; i < nameslist.size(); ++i) {
//            namesArray[i] = nameslist.get(i);
//        }
//
//        // copy from an array to a List
//        for (int i = 0; i < namesArray.length; ++i) {
//             nameslist.add(namesArray[i]);
//        }

//        names.remove(0);
//        names.add(0, "Harry");

//        nameslist.remove("Kim");
//        nameslist.set(0, "Harry");
//
//        namesArray[0] = "Joe";


        // for-each loop
//        for(String name : namesList) {
//            System.out.println("Name: " + name);
//
//            // can't do this
////            if (namesList.contains("Joe")) {
////                namesList.remove("Joe");
////            }
//        }
//
//        System.out.println("=========================");
////
//        // for loop with index
//        for(int i = 0; i < namesList.size(); ++i) {
//
//            // This is okay!
//            if (namesList.contains("Joe")) {
//                namesList.remove("Joe");
//            }
//
//            System.out.println("Name " + i + ": " + namesList.get(i));
//
//
//
//        }

        System.out.println("=========================");

        // Maps
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Joe", 22);
        ages.put("Mary", 18);
        ages.put("Sam", 21);
        ages.put("Kim", 24);

        //ages.remove("Joe");

        ages.put("Joe", 26);
        ages.put("Joe", 28);

      //  System.out.println("Joe's age is " + ages.get("Joe"));


        // iterate keys
//        for (String key: ages.keySet()) {
//            System.out.println("Key: " + key);
//        }
//
//        System.out.println("=========================");

        // iterate entries
        for (Map.Entry<String, Integer> entry: ages.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

//        System.out.println("=========================");
        
    }
}
