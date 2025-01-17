package com.techelevator;

import java.util.Random;

public class Example2 {

    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber = random.nextInt(10); //picks a number from 0-9
        System.out.println("Random number is: " + randomNumber);

        /*
		For each of the print statements below, finish the description of when the boolean expression will
		evaluate to true.
		*/

        System.out.print("Random number is more than 5: ");
        System.out.println(randomNumber > 5);

        System.out.print("Random number is between 2 and 7 ");
        System.out.println(randomNumber >= 2 && randomNumber <= 7);

        System.out.print("Random number is NOT 2, 4 or 6 ");
        System.out.println(!(randomNumber == 2 || randomNumber == 4 || randomNumber == 6));

        System.out.print("Random number is either div by 2 or 3 but not both ");
        System.out.println(randomNumber % 2 == 0 ^ randomNumber % 3 == 0);

        System.out.print("Random number divided 10 evenly ");
        System.out.println(randomNumber > 0 && 10 % randomNumber == 0);
    }

}
