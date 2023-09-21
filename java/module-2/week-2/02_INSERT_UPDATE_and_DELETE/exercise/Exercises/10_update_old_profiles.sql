-- 10. For all people born before 1900 whose profile_path does NOT end in ".jpg", set their
--     home_page to "No image" and their profile_path to NULL (64 rows)
update person set home_page = 'No image', profile_path = NULL
where birthday < '1900-01-01' and profile_path not in (select profile_path from person where profile_path like '%.jpg')

