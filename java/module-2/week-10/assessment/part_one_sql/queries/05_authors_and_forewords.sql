-- 5. List all book titles and the first and last name of the person who wrote the foreword (name the column 'foreword_author') for books that Moishe Reiling was an author.
-- Order by book title (A-Z).
-- Tip: make sure to add a space between the author's first and last names.
-- (5 rows)

Select book_title, first_name || ' ' || last_name as foreword_author from person
join book_author on book_author.author_id = person.person_id
join book on book.book_id = book_author.book_id
where last_name = 'Reiling' group by foreword_author, book_title, foreword_by order by book_title 