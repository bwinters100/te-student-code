-- 22. The name and sales tax for states and territories with sales tax greater than or equal to 2% and less than or equal to 5% (15 rows)

select state_name, sales_tax from state where sales_tax between 2 and 5