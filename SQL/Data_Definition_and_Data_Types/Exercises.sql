-- 1.
CREATE DATABASE `minions`;
CREATE TABLE `minions` (
  `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL
  );
  
CREATE TABLE `towns` (
  `town_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL
  );


-- 2.
ALTER TABLE `minions` 
ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`) 
REFERENCES `towns` (`id`);


-- 3.
INSERT INTO `towns`(`id`, `name`)
VALUES (1, 'Sofia'), (2, 'Plovdiv'), (3, 'Varna');

INSERT INTO `minions` (`id`,`name`,`age`,`town_id`)
VALUES (1, 'Kevin', 22, 1),(2, 'Bob', 15, 3),(3, 'Steward', null, 2);


-- 4.
TRUNCATE `minions`;

-- 5.
DROP TABLE `minions`;
DROP TABLE `towns`;

-- 6.
CREATE TABLE `people` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `age` DOUBLE 
);

-- 7.
CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

CREATE TABLE `addresses` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` VARCHAR(45),
`town_id` INT , 
CONSTRAINT fk_addresses_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`)
);

CREATE TABLE `departments` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`middle_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`job_title` VARCHAR(20) NOT NULL,
`department_id` INT NOT NULL,
`hire_date` DATE, 
`salary` DECIMAL(19,2),
`address_id` INT,
CONSTRAINT fk_employees_departments
FOREIGN KEY (`department_id`)
REFERENCES `departments`(`id`),
CONSTRAINT fk_employees_addresses
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`)
);

INSERT INTO `towns` 
values(1, 'Sofia'), (2, 'Plovdiv'), (3, 'Varna'), (4, 'Burgas');

INSERT INTO `departments` 
values(1, 'Engineering'), (2, 'Sales'), (3, 'Marketing'), (4, 'Software Development'), (5, 'Quality Assurance');

INSERT INTO `employees` (`id`, `first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
values
(1, 'Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00), 
(2, 'Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
(3, 'Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
(4, 'Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
(5, 'Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);


-- 8.
select * from `towns`;
select * from `addresses`;
select * from `departments`;
select * from `employees`;

-- 9.
select * from `towns`
order by `name`;

select * from `departments`
order by `name`;

select * from `employees`
order by `salary` desc;

-- 10.
SELECT `name` from `towns`
order by `name`;

SELECT `name` from `departments`
order by `name`;

SELECT `first_name`, `last_name`, `job_title`, `salary` 
from `employees`
order by `salary` desc;


-- 11employees.
update `employees`
set `salary` = `salary` + 1000;
