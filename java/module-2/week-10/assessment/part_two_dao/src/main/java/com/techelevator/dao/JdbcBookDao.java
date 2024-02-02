package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = null;
        String sql = "SELECT * FROM book WHERE book_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId);
            if (results.next()) {
                book = mapRowToBook(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(e.getMessage());
        }

        return book;
    }

    @Override
    public Book createBook(Book newBook) {
        try {
            Integer bookId = jdbcTemplate.queryForObject("Insert into book (book_id, book_title, star_rating, out_of_print, foreword_by, publisher_id, published_date) Values (?,?,?,?,?,?,?) RETURNING book_id;", int.class, newBook.getBookTitle(), newBook.getStarRating(),newBook.isOutOfPrint(), newBook.getForewordBy(), newBook.getPublisherId(), newBook.getPublishedDate());
            newBook.setBookId(bookId);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage());
        }
        return newBook;
    }

    @Override
    public int deleteBookById(int bookId) {
        {
            int numOfRows = 0;
            String empSQL = "Delete from book_author where book_id = ?;";
            String depSQL = "Delete from book where book_id = ?;";
            try{
                jdbcTemplate.update(empSQL, bookId);
                numOfRows = jdbcTemplate.update(depSQL, bookId);
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            } catch (DataIntegrityViolationException e) {
                throw new DaoException("Data integrity violation", e);
            }
            return numOfRows;
        }
    }

    private Book mapRowToBook(SqlRowSet results) {
        Book book = new Book();
        book.setBookId(results.getInt("book_id"));
        book.setBookTitle(results.getString("book_title"));
        book.setStarRating(results.getBigDecimal("star_rating"));
        book.setOutOfPrint(results.getBoolean("out_of_print"));
        book.setForewordBy((Integer) results.getObject("foreword_by"));
        book.setPublisherId(results.getInt("publisher_id"));
        book.setPublishedDate(results.getDate("published_date").toLocalDate());
        return book;
    }
}
