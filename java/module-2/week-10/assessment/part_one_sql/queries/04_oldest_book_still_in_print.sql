-- 4. Select the title and published date of the earliest published book still in print.
-- (1 rows, expected title starts with "C")

select book_title, published_date from book
where out_of_print = false order by published_date limit 1