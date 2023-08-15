package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the length: ");
		Double userInput = input.nextDouble();
		Scanner inputTwo = new Scanner(System.in);
		System.out.println("Is the measure in (m)eters, or (f)eet? ");
		String userInputTwo = inputTwo.nextLine();
		if(userInputTwo.equals("m")){
			double newInput = (userInput * 3.2808399);
			System.out.println(userInput + userInputTwo + " is " + newInput + "f" );
		}
		else if (userInputTwo.equals("f")){
			double newInput = (userInput * 0.3048);
			System.out.println(userInput + userInputTwo + " is " + newInput + "m" );
		}
	}

}
