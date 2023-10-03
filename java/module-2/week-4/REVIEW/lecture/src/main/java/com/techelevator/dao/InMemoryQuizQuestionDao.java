package com.techelevator.dao;

import com.techelevator.QuizQuestion;

import java.util.Arrays;
import java.util.List;

public class InMemoryQuizQuestionDao implements QuizQuestionDao {

    private static final QuizQuestion[] QUESTIONS = {
            new QuizQuestion("Which of these films is NOT set in Los Angeles?",
                    new String[]{"RoboCop", "Blade Runner", "The Terminator", "Predator 2"}, 1),
            new QuizQuestion("Which two teams played in Super Bowl XLII?",
                    new String[]{"The Green Bay Packers & The Pittsburgh Steelers", "The Philadelphia Eagles & The New England Patriots", "The New York Giants & The New England Patriots", "The Seattle Seahawks & The Denver Broncos"}, 3)
    };

    @Override
    public List<QuizQuestion> getQuestionsForQuiz(String quizName) {
        return Arrays.asList(QUESTIONS);
    }
}
