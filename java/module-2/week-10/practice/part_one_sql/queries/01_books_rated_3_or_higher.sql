-- 1. List the title, the date published, and the star_rating of all books with a star_rating of at least 3.
-- Order the results by rating, with the lowest rating first.
-- (20 rows)
Select book_title, published_date, star_rating from book where star_rating >= 3 order by star_rating