package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		int firstNum = 0;
		int secondNum = 1;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int userInput = input.nextInt();
		for(int i = 0; firstNum <= userInput; i++){
			System.out.print(firstNum + ", ");
			int twoSome = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = twoSome;
		}
	}

}
