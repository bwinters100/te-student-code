package com.techelevator;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }


    public void run() {
        Student student1 = new Student("Bob", 1001);
        Student student2 = new Student("Mary", 1056);

        student1.addGrade(1, 87.9);
        student1.addGrade(2, 78.0, 5);
        student1.addGrade(3, 91.6);

        student2.addGrade(1, 87.5);
        student2.addGrade(2, 94.6, 5);
        student2.addGrade(3, 100.0);

        System.out.println("Students");
        System.out.println("==========================================");
        System.out.println(student1);
        System.out.println(student2);
    }
}
