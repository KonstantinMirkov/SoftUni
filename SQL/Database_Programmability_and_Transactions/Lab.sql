--  1.
DROP FUNCTION IF EXISTS ufn_count_employees_by_town;

DELIMITER //
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(45)) 
RETURNS INT DETERMINISTIC
BEGIN
DECLARE emp_count INT;
SET emp_count := (SELECT COUNT(*) FROM employees
JOIN addresses USING(address_id)
JOIN towns t USING(town_id)
WHERE t.`name` = town_name);
RETURN emp_count;
END //
DELIMITER ;

SELECT ufn_count_employees_by_town("Sofia") AS "count";


-- 2.
DROP PROCEDURE IF EXISTS usp_raise_salaries
DELIMITER //
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN 
UPDATE employees AS e
JOIN departments AS d
ON e.department_id = d.department_id
SET salary = salary * 1.05
WHERE d.name = department_name;
END //
DELIMITER ;

SELECT e.first_name, e.salary 
FROM employees AS e
JOIN departments AS d
ON e.department_id = d.department_id
WHERE d.name = "Finance"
ORDER BY e.first_name;


-- 3.
DROP PROCEDURE IF EXISTS usp_raise_salary_by_id
DELIMITER //
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN 
   START TRANSACTION;
   IF((SELECT COUNT(*) FROM employees WHERE employee_id = id) = 0)
   THEN ROLLBACK;
   ELSE 
   UPDATE employees
   SET salary = salary * 1.05
   WHERE employee_id = id;
   COMMIT;
END IF;
END //
DELIMITER ;

CALL usp_raise_salary_by_id(178);
SELECT SUM(salary) AS salary FROM employees;


-- 4.
DROP TABLE IF EXISTS deleted_employees;

CREATE TABLE deleted_employees(
employee_id INT PRIMARY KEY AUTO_INCREMENT, 
first_name VARCHAR(25),
last_name VARCHAR(25),
middle_name VARCHAR(25),
job_title VARCHAR(50),
deparment_id INT ,
salary DOUBLE 
);

DROP TRIGGER IF EXISTS tr_deleted_employees;
DELIMITER //
CREATE TRIGGER tr_deleted_employees
AFTER DELETE 
ON employees
FOR EACH ROW 
BEGIN
INSERT INTO deleted_employees(employee_id, first_name, last_name, middle_name, job_title, deparment_id, salary)
VALUES (OLD.first_name, OLD.last_name, OLD.middle_name, OLD.job_title, OLD.department_id, OLD.salary);
END //

DELIMITER ;
DELETE FROM employees WHERE employee_id = 298;