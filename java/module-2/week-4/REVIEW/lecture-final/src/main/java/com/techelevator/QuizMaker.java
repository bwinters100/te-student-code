package com.techelevator;

import com.techelevator.dao.FileQuizQuestionDao;
import com.techelevator.dao.InMemoryQuizQuestionDao;
import com.techelevator.dao.JdbcQuizQuestionDao;
import com.techelevator.dao.JdbcQuizQuestionDaoX;
import com.techelevator.dao.QuizQuestionDao;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class QuizMaker {

    private QuizQuestionDao dao;

    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        QuizMaker quizMaker = new QuizMaker();
        quizMaker.run();
    }

    public QuizMaker() {
//        String url = System.getenv("DB_URL"); // e.g. jdbc:postgresql://localhost:5432/Quiz
        String url = "jdbc:postgresql://localhost:5432/Quiz";
        Boolean inMem = Boolean.parseBoolean(System.getenv("IN_MEM"));
        if (inMem) {
            dao = new InMemoryQuizQuestionDao();
        } else if (url != null) {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(url);
//            dataSource.setUsername(System.getenv("DB_USER"));
//            dataSource.setPassword(System.getenv("DB_PASSWORD"));
            dataSource.setUsername("postgres");
            dataSource.setPassword("postgres1");
            Boolean useX = Boolean.parseBoolean(System.getenv("USE_X"));
            dao = useX ? new JdbcQuizQuestionDaoX(dataSource) : new JdbcQuizQuestionDao(dataSource);
        } else {
            dao = new FileQuizQuestionDao();
        }
    }

    private void run() {
        System.out.println("Please enter the name of the quiz: ");
        String name = userInput.nextLine();
        List<QuizQuestion> quiz = dao.getQuestionsForQuiz(name);
        int numberRight = deliverQuiz(quiz);
        System.out.println("You got " + numberRight + " answer(s) correct out of the "
                + quiz.size() + " question(s) asked.");
    }


    private int deliverQuiz(List<QuizQuestion> quizQuestions) {
        int numberOfCorrectAnswers = 0;
        for (QuizQuestion quizQuestion : quizQuestions) {
            int answerNum = promptForInt(quizQuestion + "\nYour answer? ");
            if (quizQuestion.getCorrectAnswer() == answerNum) {
                System.out.println("Correct!");
                numberOfCorrectAnswers += 1;
            } else {
                System.out.println("Sorry that isn't correct!");
            }
        }
        return numberOfCorrectAnswers;
    }

    private int promptForInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String reply = userInput.nextLine();
                return Integer.parseInt(reply);
            } catch (NumberFormatException e) {
                System.out.println("---Only numbers, please.---");
            }
        }
    }


}
