-- 1. List the titles of all books, the name of the publisher, and the date published. 
-- Order the results by published date, earliest first.
-- (33 rows)
select book_title, publisher_name, published_date from book
join publisher on publisher.publisher_id = book.publisher_id
order by published_date asc