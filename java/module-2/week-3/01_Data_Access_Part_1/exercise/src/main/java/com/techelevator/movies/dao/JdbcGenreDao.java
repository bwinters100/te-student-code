package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        List <Genre> genres = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from genre");
        while(rs.next()){
            Genre genre = new Genre();
            genres.add(genre);

        }
        return genres;
    }

    @Override
    public Genre getGenreById(int id) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from genre where genre_id = ?", id);
        if(rs.next()){
            Genre genre = mapGenre(rs);
            return genre;
        }
        return null;
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        List<Genre> genres = new ArrayList<>();
        if(useWildCard){
            name = "%" + name + "%";
        }
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from genre where genre_name ILIKE ?", name );
        while(rs.next()){
            genres.add(mapGenre(rs));
        }
        return genres;
    }
    private static Genre mapGenre(SqlRowSet rs){
        int id = rs.getInt("genre_id");
        String name = rs.getString("genre_name");
        Genre genre = new Genre();
        genre.setId(id);
        genre.setName(name);
        return genre;
    }
}
