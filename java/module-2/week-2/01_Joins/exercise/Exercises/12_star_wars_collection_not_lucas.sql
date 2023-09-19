-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)

select distinct title from movie 
join collection on collection.collection_id = movie.collection_id
join movie_actor on movie_actor.movie_id = movie.movie_id
join person on person.person_id = movie.director_id
where collection_name = 'Star Wars Collection' and person_name != 'George Lucas' order by title 