package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List <Person> persons = new ArrayList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from person");
        while(rs.next()){
            Person person = new Person();
            persons.add(person);

        }
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from person where person_id = ?", id);
        if(rs.next()){
            Person person = mapPerson(rs);
            return person;
        }
        return null;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> persons = new ArrayList<>();
        if(useWildCard){
            name = "%" + name + "%";
        }
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from person where person_name LIKE ?", name );
        while(rs.next()){
            persons.add(mapPerson(rs));
        }
        return persons;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> persons = new ArrayList<>();
        if(useWildCard){
            collectionName = "%" + collectionName + "%";
        }
        SqlRowSet rs = jdbcTemplate.queryForRowSet("Select * from person join movie_actor on movie_actor.actor_id = person.person_id join movie on movie.movie_id = movie_actor.movie_id join collection on collection.collection_id = movie.collection_id where collection_name ILIKE ?", collectionName);
        while(rs.next()){
            persons.add(mapPerson(rs));
        }
        return persons;
    }

    private static Person mapPerson(SqlRowSet rs){
        Person person = new Person();
        int id = rs.getInt("person_id");
        String name = rs.getString("person_name");
        if( rs.getDate("birthday") != null ){
            LocalDate birthday = rs.getDate("birthday").toLocalDate();
            person.setBirthday(birthday);
        }
        if( rs.getDate("deathday") != null ){
            LocalDate deathDate = rs.getDate("deathday").toLocalDate();
            person.setDeathDate(deathDate);
        }
        String biography = rs.getString("biography");
        String profilePath = rs.getString("profile_path");
        String homePage = rs.getString("home_page");
        person.setId(id);
        person.setName(name);
        person.setBiography(biography);
        person.setProfilePath(profilePath);
        person.setHomePage(homePage);
        return person;
    }
}
