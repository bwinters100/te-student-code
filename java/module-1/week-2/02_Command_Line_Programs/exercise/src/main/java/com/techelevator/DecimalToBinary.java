package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter in a series of decimal values (separated by spaces): ");
		String userInput = input.nextLine();
		int decimal = Integer.parseInt(userInput);
		int num = decimal%2;
		String[] intArray = userInput.split( "");
		for(String element : intArray){

		}
	}

}