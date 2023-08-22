package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() throws FileNotFoundException {
		/* Your code goes here */
		System.out.println("What is the fully qualified name of the file that should be searched?");
		String fileName = userInput.nextLine();
		File searchFile = new File(fileName);
		try (Scanner inputScanner = new Scanner(searchFile)) {
			int lineNum = 1;
			int count = 0;
			System.out.println("What is the search word you are looking for?");
			String word = userInput.nextLine();
			System.out.println("Should the search be case sensitive? (Y\\N)");
			String answer = userInput.nextLine();
			if(answer.equals("N")){
				word = word.toLowerCase();
				count++;
			}
			while (inputScanner.hasNext()) {
				String lineInput = inputScanner.nextLine();
				if(count == 1){
					String sub = lineInput.toLowerCase();
					if(sub.contains(word)){
						System.out.println(lineNum + ") " + lineInput);
						lineNum++;
					}
					else{
						lineNum++;
					}
				}
				else if(lineInput.contains(word)) {
					System.out.println(lineNum + ") " + lineInput);
					lineNum++;
				}
				else{
					lineNum++;
				}
			}
		}
	}
}
