-- 1.
CREATE TABLE `passports`(
`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
`passport_number` VARCHAR(45) UNIQUE 
);

CREATE TABLE `people`(
`person_id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(45) NOT NULL,
`salary` DECIMAL(10,2),
`passport_id` INT UNIQUE,
CONSTRAINT fk_passport_id FOREIGN KEY(`passport_id`)
REFERENCES `passports`(`passport_id`) 
);

INSERT INTO `passports`
VALUES 
(101, "N34FG21B"),
(102, "K65LO4R7"),
(103, "ZE657QP2");

INSERT INTO `people` (`first_name`, `salary`, `passport_id`)
VALUES 
("Roberto",43300.00, 102),
("Tom",56100.00, 103),
("Yana",60200.00, 101);


-- 2.
CREATE TABLE `manufacturers`(
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`established_on` DATE
);

CREATE TABLE `models`(
`model_id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`manufacturer_id` INT,
CONSTRAINT fk_manufacturer_id FOREIGN KEY(`manufacturer_id`)
REFERENCES `manufacturers`(`manufacturer_id`)
);

INSERT INTO `manufacturers` (`name`, `established_on`)
VALUES 
("BMW", "1916-03-01"),
("Tesla", "2003-01-01"),
("Lada", "1966-05-01");

INSERT INTO `models`
VALUES 
(101, "X1", 1),
(102, "i6", 1),
(103, "Model S", 2),
(104, "Model X", 2),
(105, "Model 3", 2),
(106, "Nova", 3);


-- 3.
CREATE TABLE `students`(
`student_id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);


CREATE TABLE `exams`(
`exam_id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

INSERT INTO `students`(`student_id`, `name`)
VALUES
(1, "Mila"),
(2, "Toni"),
(3, "Ron");

INSERT INTO `exams`(`exam_id`, `name`)
VALUES
(101, "Spring MVC"),
(102, "Neo4j"),
(103, "Oracle 11g");


CREATE TABLE `students_exams`(
`student_id`INT,
`exam_id` INT,
CONSTRAINT pk_students_exams PRIMARY KEY(`student_id`, `exam_id`),

CONSTRAINT fk_students_exams_students FOREIGN KEY(`student_id`)
REFERENCES `students`(`student_id`),

CONSTRAINT fk_students_exams_exams FOREIGN KEY(`exam_id`)
REFERENCES `exams`(`exam_id`)
);

INSERT INTO `students_exams`(`student_id`, `exam_id`)
VALUES
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);


-- 4.
CREATE TABLE `teachers` (
`teacher_id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`manager_id` INT
);

INSERT INTO `teachers` VALUES 
(101, "John", NULL),
(102, "Maya", 106),
(103, "Silvia", 106),
(104, "Ted", 105),
(105, "Mark", 101),
(106, "Greta", 101);

ALTER TABLE `teachers`
ADD CONSTRAINT fk_manager_id FOREIGN KEY(`manager_id`)
REFERENCES `teachers`(`teacher_id`);


-- 5.
CREATE TABLE item_types (
    item_type_id INT AUTO_INCREMENT,
    name VARCHAR(50),
    CONSTRAINT pk_item_types PRIMARY KEY (item_type_id)
);

CREATE TABLE cities (
    city_id INT AUTO_INCREMENT,
    name VARCHAR(50),
    CONSTRAINT pk_cities PRIMARY KEY (city_id)
);

CREATE TABLE items (
    item_id INT AUTO_INCREMENT,
    name VARCHAR(50),
    item_type_id INT,
    CONSTRAINT pk_items PRIMARY KEY (item_id)
);

CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT,
    name VARCHAR(50),
    birthday DATE,
    city_id INT,
    CONSTRAINT pk_customers PRIMARY KEY (customer_id)
);

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT,
    customer_id INT,
    CONSTRAINT pk_orders PRIMARY KEY (order_id)
);

CREATE TABLE order_items (
    order_id INT,
    item_id INT,
    CONSTRAINT pk_order_items PRIMARY KEY (order_id , item_id)
);


ALTER TABLE items
    add constraint fk_items_item_types FOREIGN KEY(item_type_id)
    REFERENCES item_types(item_type_id);

ALTER TABLE customers
    ADD CONSTRAINT fk_customers_cities FOREIGN KEY(city_id)
    REFERENCES cities(city_id);

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_customers FOREIGN KEY(customer_id)
    REFERENCES customers(customer_id);

ALTER TABLE order_items
    ADD CONSTRAINT fk_order_items_orders FOREIGN KEY(order_id)
    REFERENCES orders(order_id),
    ADD CONSTRAINT fk_order_items_items FOREIGN KEY(item_id)
    REFERENCES items(item_id);
    
    
-- 6.
CREATE TABLE majors(
	major_id INT AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_majors
    PRIMARY KEY(major_id)
);

CREATE TABLE subjects(
	subject_id INT AUTO_INCREMENT,
    subject_name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_subjects
    PRIMARY KEY(subject_id)
);

CREATE TABLE payments(
	payment_id INT AUTO_INCREMENT,
    payment_date DATE NOT NULL,
    payment_amount DECIMAL(8,2),
    student_id INT,
    CONSTRAINT pk_payments
    PRIMARY KEY(payment_id)
);

CREATE TABLE students(
	student_id INT AUTO_INCREMENT,
    student_number VARCHAR(12) NOT NULL,
    student_name VARCHAR(50) NOT NULL,
    major_id INT,
    CONSTRAINT pk_students
    PRIMARY KEY(student_id),
    CONSTRAINT fk_students_majors
    FOREIGN KEY(major_id)
    REFERENCES majors(major_id)
);

ALTER TABLE payments
ADD CONSTRAINT fk_payments_students
FOREIGN KEY(student_id)
REFERENCES students(student_id);

CREATE TABLE agenda(
	student_id INT,
    subject_id INT,
    CONSTRAINT pk_agenda
    PRIMARY KEY(student_id, subject_id),
    CONSTRAINT fk_agenda_students
    FOREIGN KEY(student_id)
    REFERENCES students(student_id),
    CONSTRAINT fk_agenda_subjects
    FOREIGN KEY(subject_id)
    REFERENCES subjects(subject_id)
);

-- 7.
SELECT m.mountain_range, p.peak_name, p.elevation AS peak_elevation
FROM mountains AS m JOIN peaks AS p
ON m.id = p.mountain_id
WHERE m.mountain_range = 'Rila'
ORDER BY p.elevation DESC;