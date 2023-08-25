package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
            try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(filename, appendFile))) {
                dataOutput.println(contents);
                } catch(FileNotFoundException e) {
                System.out.println(e.getMessage());
                }
            }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> contentsFromFile = new ArrayList<>();
        File dataFile = new File(filename);
        try(Scanner dataInput = new Scanner(dataFile)){
            while(dataInput.hasNextLine()){
                String lineOfInput = dataInput.nextLine();
                contentsFromFile.add(lineOfInput);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return contentsFromFile;
    }
}
