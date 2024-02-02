-- 3. List the publisher name and the highest star rating for each publisher (name the column 'highest_rating'). 
-- Order the results by rating, highest first.
-- (4 rows, starting with T&E Publishing)

select publisher_name, max(star_rating) as highest_rating from publisher 
join book on publisher.publisher_id = book.publisher_id
group by publisher_name order by highest_rating desc