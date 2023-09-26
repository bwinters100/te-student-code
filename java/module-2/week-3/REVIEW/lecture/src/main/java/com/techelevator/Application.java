package com.techelevator;

import com.techelevator.dao.DictionaryEntryDao;
import com.techelevator.dao.JdbcDictionaryEntryDao;
import com.techelevator.model.DictionaryEntry;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class Application {

    private final DictionaryEntryDao dictionaryEntryDao;
    private final Scanner scanner = new Scanner(System.in);

    public Application(DictionaryEntryDao dictionaryEntryDao) {
        this.dictionaryEntryDao = dictionaryEntryDao;
    }

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Dictionary");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        DictionaryEntryDao dictionaryEntryDao = new JdbcDictionaryEntryDao(new JdbcTemplate(dataSource));
        Application application = new Application(dictionaryEntryDao);
        application.run();
    }

    private void run() {
        String word = "";
        while (!word.equalsIgnoreCase("exit")) {
            System.out.println("------------");
            System.out.print("Enter a word to look up: ");
            word = scanner.nextLine();
            if (!word.equalsIgnoreCase("exit")) {
                try {
                    DictionaryEntry entry = dictionaryEntryDao.getDictionaryEntryByWord(word);
                    if (entry == null) {
                        System.out.println("The word " + word + " was not found!");
                    } else {
                        System.out.println(entry);
                    }
                } catch (Exception e) {
                    System.out.println("Whoops!  Something went wrong.  " + e.getMessage());
                }
            }
        }
    }
}
