package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("Please enter a file for destination: ");
		String fileAnswer = userInput.nextLine();
		try(PrintWriter writer = new PrintWriter(fileAnswer)){
			for (int i = 1; i <= 300; i++){
				if(i % 3 == 0 && i % 5 == 0) {
					writer.println("FizzBuzz");
				}
				else if(i % 5 == 0){
					writer.println("Buzz");
				}
				else if(i % 3 == 0) {
					writer.println("Fizz");
				}
				else {
					writer.println(i);
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
