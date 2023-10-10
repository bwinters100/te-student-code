package com.techelevator.dao;

import com.techelevator.QuizQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcQuizQuestionDaoX implements QuizQuestionDao {

    JdbcTemplate jdbcTemplate;

    public JdbcQuizQuestionDaoX(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<QuizQuestion> getQuestionsForQuiz(String quizName) {
        String sql = "SELECT question.question_id, question_text, correct_answer\n" +
                "FROM question\n" +
                "JOIN quiz_question qq ON qq.question_id = question.question_id\n" +
                "JOIN quiz ON quiz.quiz_id = qq.quiz_id\n" +
                "WHERE quiz_name = ?\n" +
                "ORDER BY question_number;";

        return jdbcTemplate.query(sql, new QuizQuestionRowMapper(), quizName);
    }

    private String[] getAnswersForQuestion(int questionId) {
        String sql = "SELECT answer_text\n" +
                "FROM answer\n" +
                "WHERE question_id = ?\n" +
                "ORDER BY answer_number;";

        return jdbcTemplate.query(sql, new AnswerRowMapper(), questionId).toArray(new String[0]);
    }


    private class QuizQuestionRowMapper implements RowMapper<QuizQuestion> {
        @Override
        public QuizQuestion mapRow(ResultSet resultSet, int i) throws SQLException {
            QuizQuestion quizQuestion = new QuizQuestion();
            quizQuestion.setQuestion(resultSet.getString("question_text"));
            quizQuestion.setCorrectAnswer(resultSet.getInt("correct_answer"));
            quizQuestion.setAnswers(getAnswersForQuestion(resultSet.getInt("question_id")));
            return quizQuestion;
        }
    }

    private static class AnswerRowMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getString("answer_text");
        }
    }
}
