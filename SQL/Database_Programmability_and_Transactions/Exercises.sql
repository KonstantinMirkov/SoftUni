-- 1.
DROP PROCEDURE IF EXISTS usp_get_employees_salary_above_35000
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN 
SELECT first_name, last_name
FROM employees
WHERE salary > 35000
ORDER BY first_name , last_name , employee_id;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above_35000();


-- 2.
DROP PROCEDURE IF EXISTS usp_get_employees_salary_above;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(min_salary DECIMAL(19,4))
BEGIN 
SELECT first_name, last_name
FROM employees
WHERE salary >= min_salary
ORDER BY first_name , last_name , employee_id;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above(45000);


-- 3.
DROP PROCEDURE IF EXISTS usp_get_towns_starting_with;
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(letter VARCHAR(20))
BEGIN
SELECT `name` FROM towns
WHERE `name`LIKE concat(letter, "%")
ORDER BY `name`;
END $$
DELIMITER ;

CALL usp_get_towns_starting_with('b');


-- 4.
DROP PROCEDURE IF EXISTS usp_get_employees_from_town;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(20))
BEGIN
SELECT e.first_name, e.last_name FROM employees AS e
JOIN addresses AS a 
ON e.address_id = a.address_id
JOIN towns AS t
ON a.town_id = t.town_id
WHERE t.`name` = town_name
ORDER BY e.first_name, e.last_name, e.employee_id;
END $$
DELIMITER ;

CALL usp_get_employees_from_town("Sofia");


-- 5 and 6.
DROP FUNCTION IF EXISTS ufn_get_salary_level;
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(e_salary DECIMAL)
RETURNS VARCHAR(10) DETERMINISTIC
BEGIN
   RETURN (CASE 
   WHEN e_salary < 30000 THEN "Low"
   WHEN e_salary BETWEEN 30000 AND 50000 THEN "Average"
   WHEN e_salary > 50000 THEN "High"
   END
   );
END $$
DELIMITER ;

SELECT ufn_get_salary_level(52000);

DROP PROCEDURE IF EXISTS usp_get_employees_by_salary_level;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(s_level VARCHAR(10))
BEGIN
SELECT first_name, last_name FROM employees
WHERE ufn_get_salary_level(salary) = s_level
ORDER BY first_name DESC, last_name DESC; 
END $$
DELIMITER ;

CALL usp_get_employees_by_salary_level("High");


-- 7.
DROP FUNCTION IF EXISTS ufn_is_word_comprised;
DELIMITER $$
create function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
returns int
deterministic
begin
	declare indx int;
    declare symbol varchar(1);
    set indx := 1;
    while indx <= char_length(word) do
		set symbol := substring(word, indx, 1);
        if locate(symbol, set_of_letters) = 0
			then return 0;
        end if;
        set indx := indx + 1;
	end while;
    return 1;
end $$
DELIMITER ;

SELECT ufn_is_word_comprised("oistmiahf", "halves");


-- 8.
DROP PROCEDURE IF EXISTS usp_get_holders_full_name;
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT
		concat_ws(" ",ah.first_name, ah.last_name) AS full_name
	FROM account_holders ah
    ORDER BY full_name, id;
END $$
DELIMITER ;

CALL usp_get_holders_full_name();


-- 9.
DROP PROCEDURE IF EXISTS usp_get_holders_with_balance_higher_than;
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(supplied_number DECIMAL (19,4))
BEGIN 
SELECT ah.first_name, ah.last_name from account_holders AS ah
JOIN accounts AS a
ON ah.id = a.account_holder_id 
GROUP BY ah.id
HAVING SUM(a.balance) >= supplied_number
ORDER BY ah.id ASC;
END $$
DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);


-- 10 And 11.
DROP FUNCTION IF EXISTS ufn_calculate_future_value;
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL (19,4), interest DOUBLE, years INT)
RETURNS DECIMAL (19,4)
DETERMINISTIC
BEGIN 
DECLARE result DECIMAL(20,4);
	SET result = sum * POW((1 + interest), years);
	RETURN result;
END $$
DELIMITER ;

SELECT ufn_calculate_future_value(1000, 0.5, 5);

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(15, 4))
BEGIN
	SELECT a.id, a_h.first_name, a_h.last_name, a.balance as current_balance,
	ufn_calculate_future_value(a.balance, interest_rate, 5) as balance_in_5_years 
	FROM accounts as a 
	JOIN account_holders as a_h ON a.account_holder_id = a_h.id
	WHERE a.id = account_id;
END $$
DELIMITER ;

CALL usp_calculate_future_value_for_account(1, 0.1);


-- 12.
DROP PROCEDURE IF EXISTS usp_deposit_money;
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id int, money_amount decimal(15,4))
BEGIN
	START TRANSACTION;
    IF(select count(id) from accounts where id = account_id) = 0
		or(money_amount <= 0)
		then rollback;
    ELSE 
		update accounts
        set balance = balance + money_amount
        where id = account_id;
    END IF;
    COMMIT;
END $$
DELIMITER ;

CALL usp_deposit_money(1, 133.1200);