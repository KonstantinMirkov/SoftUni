-- 1.
SELECT * FROM `departments`
ORDER BY `department_id`;


-- 2.
SELECT `name` FROM `departments`
ORDER BY `department_id`;


-- 3.
SELECT `first_name`, `last_name`, `salary` FROM `employees`;


-- 4.
SELECT 
    `first_name`, `middle_name`, `last_name`
FROM
    `employees`;


-- 5.
SELECT 
    concat(`first_name` , '.', `last_name`, '@softuni.bg') AS 'full_email_adress'
FROM
    `employees`;


-- 6.
SELECT DISTINCT `salary` FROM `employees`;


-- 7.
SELECT  * FROM `employees`
WHERE `job_title` = 'Sales Representative';


-- 8.
SELECT  `first_name`, `last_name`, `job_title` FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000; 


-- 9.
SELECT 
    concat_ws(' ', `first_name` , `middle_name`, `last_name`) AS 'Full Name'
FROM
    `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600);


-- 10.
SELECT  `first_name`, `last_name` FROM `employees`
WHERE `manager_id` IS NULL;


-- 11.
SELECT `first_name`, `last_name`, `salary` FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;


-- 12.
SELECT `first_name`, `last_name` FROM `employees`
ORDER BY `salary` DESC LIMIT 5;


-- 13.
SELECT `first_name`, `last_name` FROM `employees`
WHERE `department_id` != 4;


-- 14.
SELECT * FROM `employees`
ORDER BY `salary` DESC, 
`first_name`,
`last_name` DESC,
`middle_name`;


-- 15.
Create VIEW v_employees_salaries AS
SELECT `first_name`, `last_name`, `salary`
FROM `employees`;


-- 16.
Create VIEW v_employees_job_titles AS
SELECT concat_ws(' ', `first_name` , `middle_name`, `last_name`) AS 'full_name', `job_title` FROM `employees`;


-- 17.
SELECT DISTINCT `job_title` FROM `employees`;


-- 18.
SELECT * FROM `projects` AS p
ORDER BY p.`start_date`, p.`name` LIMIT 10;


-- 19.
SELECT `first_name`, `last_name`, `hire_date` FROM `employees`
ORDER BY `hire_date` DESC LIMIT 7;


-- 20.
UPDATE `employees`
SET `salary` = `salary` + `salary` * 0.12
WHERE `department_id` in (1, 2, 4, 11);
select `salary` from `employees`;

-- 21.
SELECT `peak_name` FROM `peaks`
ORDER BY `peak_name`;


-- 22.
SELECT `country_name`, `population` from `countries`
WHERE continent_code = 'EU'
ORDER BY population DESC, country_name ASC
LIMIT 30;


-- 23.
SELECT `country_name`, `country_code`, if(`currency_code` = 'EUR', 'Euro', 'Not Euro') AS 'currency' FROM `countries`
ORDER BY `country_name`;


-- 24.
SELECT `name` FROM `characters`
ORDER BY `name`;




