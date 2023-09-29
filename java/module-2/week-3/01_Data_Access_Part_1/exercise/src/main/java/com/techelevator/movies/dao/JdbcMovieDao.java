package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List <Movie> movies = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from movie");
        while(rs.next()){
            Movie movie = new Movie();
            movies.add(movie);

        }
        return movies;
    }

    @Override
    public Movie getMovieById(int id) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from movie where movie_id = ?", id);
        if(rs.next()){
            Movie movie = mapMovie(rs);
            return movie;
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movies = new ArrayList<>();
        if(useWildCard){
            title = "%" + title + "%";
        }
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from movie where title ILIKE ?", title );
        while(rs.next()){
            movies.add(mapMovie(rs));
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear,
                                                              int endYear, boolean useWildCard) {
        LocalDate one = LocalDate.of(startYear, Month.JANUARY, 1);
        LocalDate two = LocalDate.of(endYear, Month.DECEMBER, 31);

        List<Movie> movies = new ArrayList<>();
        if(useWildCard){
            directorName = "%" + directorName + "%";
        }
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from movie join person on person.person_id = movie.director_id where person_name ILIKE ? and release_date between ? and ?", directorName, one, two);
        while(rs.next()){
            movies.add(mapMovie(rs));
        }
        return movies;
    }
    private static Movie mapMovie(SqlRowSet rs){
        int id = rs.getInt("movie_id");
        String title = rs.getString("title");
        String overview = rs.getString("overview");
        String tagline = rs.getString("tagline");
        String posterPath = rs.getString("poster_path");
        String homePage = rs.getString("home_page");
        LocalDate releaseDate = rs.getDate("release_date").toLocalDate();
        int lengthMinutes = rs.getInt("length_minutes");
        int directorId = rs.getInt("director_id");
        int collectionId = rs.getInt("collection_id");
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setOverview(overview);
        movie.setTagline(tagline);
        movie.setPosterPath(posterPath);
        movie.setHomePage(homePage);
        movie.setReleaseDate(releaseDate);
        movie.setLengthMinutes(lengthMinutes);
        movie.setDirectorId(directorId);
        movie.setCollectionId(collectionId);
        return movie;
    }
}
