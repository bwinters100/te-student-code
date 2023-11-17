-- 2. List the first and last name of all authors (name the column 'author') and the number of books they've written (name the column 'num_books').
-- Order the results by the number of books in descending order (highest first), then by alphabetical order of the author's first name.
-- Tip: make sure to add a space between the author's first and last names.
-- (16 rows)
Select first_name || ' ' || last_name as author, count(book_title) as num_books from person
join book_author on book_author.author_id = person.person_id
join book on book.book_id = book_author.book_id
group by author order by num_books desc, author asc