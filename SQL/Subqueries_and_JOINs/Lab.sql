-- 1.
SELECT e.employee_id, CONCAT_WS(' ', e.first_name, e.last_name) AS full_name, d.department_id, d.name AS department_name 
FROM employees AS e JOIN departments AS d
ON d.manager_id = e.employee_id
ORDER BY e.employee_id
LIMIT 5;


-- 2.
SELECT t.town_id, t.name AS town_name, a.address_text 
FROM towns AS t JOIN addresses AS a
ON a.town_id = t.town_id AND name IN ("San Francisco", "Sofia", "Carnation")
GROUP BY town_id, a.address_id
ORDER BY town_id, a.address_id;


-- 3.
SELECT employee_id, first_name, last_name, d.department_id, salary 
FROM employees AS e JOIN departments AS d
ON e.department_id = d.department_id
WHERE e.manager_id IS NULL;


-- 4.
SELECT COUNT(employee_id) AS count FROM employees 
WHERE salary > (
SELECT AVG(salary) FROM employees
);