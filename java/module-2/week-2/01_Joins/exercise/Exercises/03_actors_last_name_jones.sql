-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. 
-- Order the results by the actor names (A-Z) and then by movie title (A-Z). 
-- (48 rows)
select person_name, title from person
join movie_actor on movie_actor.actor_id = person.person_id
join movie on movie.movie_id = movie_actor.movie_id
where person_name like '% Jones' order by person_name, title;