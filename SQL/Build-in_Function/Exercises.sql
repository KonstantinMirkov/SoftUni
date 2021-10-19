-- 1.
SELECT `first_name`, `last_name` FROM `employees`
WHERE LEFT(`first_name`, 2) = "Sa";


-- 2.
SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` like "%ei%";


-- 3.
SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3, 10)
AND YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;


-- 4.
SELECT `first_name`, `last_name` FROM `employees`
WHERE `job_title` NOT LIKE "%engineer%";


-- 5.
SELECT `name` FROM `towns`
WHERE char_length(`name`) IN (5, 6)
ORDER BY `name`;


-- 6.
SELECT * FROM `towns`
WHERE LEFT(`name`, 1) IN ("M", "K", "B", "E")
ORDER BY `name`;


-- 7.
SELECT * FROM `towns`
WHERE LEFT(`name`, 1) NOT IN ("R", "B", "D")
ORDER BY `name`;


-- 8.
Create VIEW v_employees_hired_after_2000 AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE YEAR(`hire_date`) > 2000;



-- 9.
SELECT `first_name`, `last_name` FROM `employees`
WHERE char_length(`last_name`) IN (5);


-- 10.
SELECT `country_name`, `iso_code` from `countries`
WHERE `country_name` LIKE "%A%A%A%"
ORDER BY `iso_code`;


-- 11.
SELECT p.`peak_name`, r.`river_name`,
LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2))) AS "mix"
FROM `peaks` AS p, `rivers` AS r
WHERE RIGHT(`peak_name`, 1) = LEFT(`river_name`, 1)
ORDER BY `mix`;


-- 12.
SELECT `name`, date_format(start, '%Y-%m-%d') AS `start` FROM `games`
WHERE YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY `start`, `name` 
LIMIT 50;


-- 13.
SELECT `user_name`, SUBSTRING(`email`, LOCATE("@", `email`)+ 1) AS "provider" FROM `users`
ORDER BY `provider`, `user_name`;


-- 14.
SELECT `user_name`, `ip_address` FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name` ASC;


-- 15.
SELECT `name` AS `game`,
(CASE 
WHEN hour(`start`) BETWEEN 0 AND 11  THEN "Morning"
WHEN hour(`start`) BETWEEN 12 AND 17  THEN "Afternoon"
ELSE "Evening"
END
) AS `Part of the Day`,
(CASE 
WHEN `duration` <= 3  THEN "Extra Short"
WHEN `duration` BETWEEN 4 AND 6  THEN "Short"
WHEN `duration` BETWEEN 7 AND 10  THEN "Long"
ELSE "Extra Long"
END
) AS `Duration`
 FROM `games`;
 
 
 -- 16.
SELECT `product_name`, `order_date`, 
adddate(`order_date`, interval 3 day) AS `pay_due`, 
adddate(`order_date`, interval 1 month) AS `deliver_due`
FROM `orders`;