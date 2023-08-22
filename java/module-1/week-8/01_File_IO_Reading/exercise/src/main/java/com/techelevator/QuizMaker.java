package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() throws FileNotFoundException {
		/* Your code goes here */
		System.out.println("Enter the fully qualified name of the file to read in for quiz questions");
		String fileName = userInput.nextLine();
		File searchFile = new File(fileName);
		Scanner files = new Scanner(searchFile);
		while (files.hasNext()) {
			String[] quizLine = files.nextLine().split("\\|");
			QuizQuestion quizQuestion = new QuizQuestion(quizLine[0], quizLine[1]);
		}
	}
}
