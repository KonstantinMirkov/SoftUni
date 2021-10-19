-- 1.
SELECT `department_id`, COUNT(`id`) AS "Number of employees" FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;

-- 2.
SELECT e.`department_id`,
ROUND(AVG(e.`salary`)  , 2) AS "Average Salary"
FROM `employees`  AS e 
GROUP BY e.`department_id`
ORDER BY e.`department_id`;


-- 3.
SELECT `department_id`,
ROUND(MIN(`salary`), 2) AS `Min Salary`
FROM `employees` 
GROUP BY `department_id`
HAVING `Min Salary` > 800
ORDER BY `department_id`;


-- 4.
SELECT `category_id`,
 ROUND(AVG(`price`)  , 2) AS `Average Price`,
 ROUND(MIN(`price`)  , 2) AS `Cheapest Product`,
 ROUND(MAX(`price`)  , 2) AS `Most Expensive Product`
FROM `products`
GROUP BY `category_id`
ORDER BY `category_id`;
