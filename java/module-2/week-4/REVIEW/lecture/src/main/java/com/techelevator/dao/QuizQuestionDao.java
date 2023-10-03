package com.techelevator.dao;

import com.techelevator.QuizQuestion;

import java.util.List;

public interface QuizQuestionDao {

    List<QuizQuestion> getQuestionsForQuiz(String quizName);
}
