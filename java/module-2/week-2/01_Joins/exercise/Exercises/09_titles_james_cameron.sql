-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)

select distinct title from movie 
join movie_actor on movie_actor.movie_id = movie.movie_id
join person on person.person_id = movie.director_id
where person_name = 'James Cameron' order by title