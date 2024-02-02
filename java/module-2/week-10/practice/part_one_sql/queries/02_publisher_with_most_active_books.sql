-- 2. Select the name of the publisher with the most books published that are not out of print.
-- Select the number of books published by them (name the column 'books_in_print').
-- (1 row)
select publisher_name, count(book_title) as books_in_print from publisher
join book on book.publisher_id = publisher.publisher_id
where out_of_print = false group by publisher_name order by books_in_print desc limit 1