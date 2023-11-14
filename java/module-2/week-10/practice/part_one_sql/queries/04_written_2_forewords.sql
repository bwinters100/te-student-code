-- 4. List the first and last name of all persons, separated by a space, (name the column 'full_name') who have written at least 2 forewords.
-- Include the count of forewords written by each person (name the column 'foreword_count').
-- Order by full_name ascending.
-- (7 rows)
select distinct first_name || ' ' || last_name as full_name, count(foreword_by) as foreword_count from person 
join book_author on book_author.author_id = person.person_id
join book on book.book_id = book_author.book_id
where foreword_by >= 2 group by full_name order by full_name asc limit 7