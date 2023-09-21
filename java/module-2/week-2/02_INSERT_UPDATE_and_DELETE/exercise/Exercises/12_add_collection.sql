-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set
--     their collection ID to the "Bill Murray Collection". (1 row, 6 rows)
insert into collection 
Values(343212, 'Bill Murray Collection');
update movie set collection_id = 343212
where movie_id in (select movie_id from movie_actor where actor_id in (select person_id from person where person_name = 'Bill Murray'));