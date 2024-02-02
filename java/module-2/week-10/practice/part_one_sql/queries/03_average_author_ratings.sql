-- 3. List the first and last name of all authors, separated by a space, (name the column 'author') and the average star rating of their books (name the column 'average_rating').
-- Order by the average rating, lowest first. Where there is a tie in average rating, use a secondary order of author (full name), ascending.
-- (16 rows)
Select first_name || ' ' || last_name as author, avg(star_rating) as average_rating from person
join book_author on book_author.author_id = person.person_id
join book on book.book_id = book_author.book_id
group by author order by average_rating asc, author asc