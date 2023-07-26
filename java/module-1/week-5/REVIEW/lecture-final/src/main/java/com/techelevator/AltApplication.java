package com.techelevator;

public class AltApplication {

    public static void main(String[] args) {
        AltApplication app = new AltApplication();
        app.run();
    }

    public void run() {
        Student student1 = new Student("Bob", 1001);
        Student student2 = new Student("Mary", 1056);

        // Use members directly
//        student1.grades[0] = 87.9;
//        student1.grades[1] = 78.0 + 5;
//        student1.grades[2] = 91.6;
//
//        student2.grades[0] = 87.5;
//        student2.grades[1] = 94.6 + 5;
//        student2.grades[2] = 100.0;

        System.out.println("Students");
        System.out.println("==========================================");
        System.out.println(student1);
        System.out.println(student2);
    }
}
