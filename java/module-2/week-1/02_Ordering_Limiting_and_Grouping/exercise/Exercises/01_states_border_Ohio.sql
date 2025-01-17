-- 1. The city name, state abbreviation, and population of all cities in the states that border Ohio.
-- The states are: Pennsylvania (PA), West Virginia (WV), Kentucky (KY), Indiana (IN), and Michigan (MI).
-- The city name and state abbreviation should be returned as a single column called 'name_and_state' and should contain values such as "Detroit, MI".
-- Order the results alphabetically by state abbreviation and then by city name.
-- (20 rows)
select city_name || ', ' || state_abbreviation as name_and_state, population from city where state_abbreviation in ('MI', 'IN', 'KY', 'WV', 'PA') order by state_abbreviation asc, city_name asc
