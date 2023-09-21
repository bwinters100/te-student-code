-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person
--     table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)
insert into person 
values(123123, 'Brent Winters', '1998-07-16', NULL, NULL, NULL, NULL);
update movie set director_id = 123123
where title = 'The Blob' 
