package com.techelevator.dao;

import com.techelevator.QuizQuestion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class    JdbcQuizQuestionDaoTest extends BaseDaoTests {


    private JdbcQuizQuestionDao dao;


    @Before
    public void setup() {
        dao = new JdbcQuizQuestionDao(dataSource);
    }

    @Test
    public void getQuestionsForQuiz() {

        List<QuizQuestion> questions = dao.getQuestionsForQuiz("test_quiz");

        Assert.assertNotNull(questions);

        Assert.assertEquals(2, questions.size());

        QuizQuestion quizQuestion = questions.get(0);
        Assert.assertEquals("What color is the sky?", quizQuestion.getQuestion());
        Assert.assertEquals(2, quizQuestion.getCorrectAnswer());

        quizQuestion = questions.get(1);
        Assert.assertEquals("A skeleton walks into a bar, and says to the bartender, \"Give me a beer and a ...\"", quizQuestion.getQuestion());
        Assert.assertEquals(3, quizQuestion.getCorrectAnswer());

    }
}