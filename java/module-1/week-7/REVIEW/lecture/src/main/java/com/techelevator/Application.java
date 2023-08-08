package com.techelevator;

import com.techelevator.model.Order;
import com.techelevator.model.Popcorn;
import com.techelevator.model.PopcornMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {


    private static final int INITIAL_POPCORN_SERVINGS = 100;
    private static final int INITIAL_SALT_SERVINGS = 75;
    private static final int INITIAL_BUTTER_SERVINGS = 75;


    private final PopcornMachine popcornMachine =
            new PopcornMachine(INITIAL_POPCORN_SERVINGS, INITIAL_SALT_SERVINGS, INITIAL_BUTTER_SERVINGS);

    public static void main(String[] args) {
        Application machine = new Application();
        machine.run();
    }


    public void run() {

        // TODO : Objective 2 : What happens if an runtime exception is thrown in this code?
        // TODO : Objective 2 : What happens if an checked exception is thrown in this code?
        // TODO : Objective 2 : Is the catch block order important?

        Scanner scanner = new Scanner(System.in);
        boolean moreOrders = true;
        int orderNumber = 1;
        List<Order> orders = new ArrayList<>();

        System.out.println("Welcome to the Popcorn Machine!");

        System.out.print("Put some money into the machine (enter amount): $");
        String moneyIn = scanner.nextLine();
        BigDecimal money = new BigDecimal(moneyIn);

        popcornMachine.addMoney(money);

        while (moreOrders) {
            System.out.println("Please enter order #" + orderNumber + ".");
            System.out.print("Enter size (S, L): ");
            String sizeIn = scanner.nextLine();
            int size = sizeIn.equalsIgnoreCase("s") ? Popcorn.SMALL_BUCKET : Popcorn.LARGE_BUCKET;

            System.out.print("Salt? (Y, N): ");
            String saltIn = scanner.nextLine();
            boolean salted = saltIn.equalsIgnoreCase("y");

            System.out.print("Butter? (Y, N): ");
            String butterIn = scanner.nextLine();
            boolean buttered = butterIn.equalsIgnoreCase("y");

            Order order = new Order(size, salted, buttered);

            orders.add(order);

            System.out.println("Order " + orderNumber + " recorded.");

            System.out.print("More orders? (Y, N): ");
            String moreIn = scanner.nextLine();
            moreOrders = moreIn.equalsIgnoreCase("y");

            orderNumber++;
        }
        popcornMachine.buyPopcorn(orders);

        // TODO: TDD : Show the user how much change they get back
    }

}
