-- 1.
CREATE TABLE `mountains` (
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
  );
CREATE TABLE `peaks` (
`id` INT PRIMARY KEY NOT NULL  AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`mountain_id` INT NOT NULL,
CONSTRAINT fk_mountain_id FOREIGN KEY(`mountain_id`)
REFERENCES `mountains`(`id`) 
ON DELETE CASCADE
  );
  
  
-- 2.
SELECT driver_id, vehicle_type, CONCAT_WS(" ", first_name, last_name) AS driver_name FROM vehicles AS v
JOIN campers AS c
ON v.driver_id = c.id;


-- 3.
SELECT starting_point AS route_starting_point, 
end_point AS route_ending_point, 
leader_id, 
CONCAT_WS(" ", first_name, last_name) AS leader_name 
FROM routes AS r
JOIN campers AS c
ON r.leader_id = c.id;


-- 4.
CREATE TABLE mountains (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45) NOT NULL
  );
CREATE TABLE peaks (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
mountain_id INT ,
CONSTRAINT fk_mountain_id FOREIGN KEY(mountain_id)
REFERENCES mountains(id) 
ON DELETE CASCADE
  );