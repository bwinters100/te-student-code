package com.techelevator;

import com.techelevator.dao.JdbcStudentDao;
import com.techelevator.dao.StudentDao;
import com.techelevator.model.Game;
import com.techelevator.model.Student;
import com.techelevator.services.GameService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class Review {
    private final StudentDao studentDao;
    private final Scanner scanner = new Scanner(System.in);

    private GameService gameService = new GameService("http://localhost:9000/");

    public Review(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/m2_review");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        StudentDao studentDao = new JdbcStudentDao(new JdbcTemplate(dataSource));

        Review review = new Review(studentDao);
        review.run();
    }

    public void run() {

        List<Game> games = gameService.getAllGames();
        System.out.println(games);




        String name = "";
        while (!name.equalsIgnoreCase("exit")) {
            System.out.println("------------");
            System.out.print("Enter a student name to look up: ");
            name = scanner.nextLine();
            if (!name.equalsIgnoreCase("exit")) {
                try {
                    List<Student> students = studentDao.getStudentByName(name);
                    System.out.println("The students with a name like " + name + " are " + students);
                } catch (Exception e) {
                    System.out.println("Whoops!  Something went wrong.  " + e.getMessage());
                }
            }
        }
    }

    public void queryWithLike() {

    }

}
