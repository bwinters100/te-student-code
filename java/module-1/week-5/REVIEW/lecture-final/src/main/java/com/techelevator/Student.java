package com.techelevator;

import java.util.*;

public class Student {
    private final String name;
    private final int id;
//    public final double[] grades = new double[3];
    private final Map<Integer, Double> grades = new HashMap<>();

    public Student(String name, int studentId) {
        this.name = name;
        id = studentId;
    }

//    public void setName(String name) {
//       this.name = name;
//    }

    public String getName() {
        return name;
    }
    public void addGrade(int testNumber, double grade) {
//        if (testNumber > 0 && testNumber <= grades.length) {
//            grades[testNumber - 1] = grade;
//        }
        grades.put(testNumber, grade);
    }

    // Overloading
    public void addGrade(int testNumber, double grade, double extraCredit) {
//        if (testNumber > 0 && testNumber <= grades.length) {
//            grades[testNumber - 1] = grade + extraCredit;
//        }
        grades.put(testNumber, grade + extraCredit);
    }

    public double getGrade(int testNumber) {
//        if (testNumber > 0 && testNumber <= grades.length) {
//            return grades[testNumber - 1];
//        }
        if (grades.containsKey(testNumber)) {
            return grades.get(testNumber);
        }
        return 0;
    }

    public double getAverage() {
        double total = 0.0;

//        for (Double grade : grades) {
//            total += grade;
//        }
//        return total / grades.length;

        for (Map.Entry<Integer, Double> gradeEntry : grades.entrySet()) {
            total += gradeEntry.getValue();
        }
        return total / grades.size();
    }

    @Override
    public String toString() {
        String s =  name +  " (" + id + ") : average = " + getAverage() + "\n";

//        for (int i = 1; i <= grades.length; ++i) {
//            s += "    " + i +") " + getGrade(i) + "\n";
//        }
        List<Integer> testNumbers = new ArrayList<>(grades.keySet());
        Collections.sort(testNumbers);
        for (Integer testNumber : testNumbers) {
            s += "    " + testNumber +") " + getGrade(testNumber) + "\n";
        }
        return s;
    }
}
