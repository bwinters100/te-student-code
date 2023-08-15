package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the temperature: ");
		Double userInput = input.nextDouble();
		Scanner inputTwo = new Scanner(System.in);
		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String userInputTwo = inputTwo.nextLine();
		if(userInputTwo.equals("C")){
			double newInput = (userInput * 1.8) + 32;
			System.out.println(userInput + userInputTwo + " is " + newInput + "F" );
		}
		else if (userInputTwo.equals("F")){
			double newInput = (userInput - 32) / 1.8;
			System.out.println(userInput + userInputTwo + " is " + newInput + "C" );
		}
	}


}
