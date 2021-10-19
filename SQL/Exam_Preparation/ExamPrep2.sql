-- 1.
CREATE TABLE users (
id INT PRIMARY KEY ,
username VARCHAR(30) NOT NULL,
`password` VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
gender CHAR(1) NOT NULL,
age INT NOT NULL,
job_title VARCHAR(40) NOT NULL,
ip VARCHAR(30) NOT NULL
);

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
address VARCHAR(30) NOT NULL,
town VARCHAR(30) NOT NULL,
country VARCHAR(30) NOT NULL,
user_id INT NOT NULL,
CONSTRAINT fk_user_id FOREIGN KEY(user_id)
REFERENCES users(id)
);

CREATE TABLE photos (
id INT PRIMARY KEY AUTO_INCREMENT,
`description` TEXT NOT NULL,
`date` DATE NOT NULL,
views INT NOT NULL DEFAULT 0
);

CREATE TABLE users_photos(
user_id INT,
photo_id INT,
CONSTRAINT pk_users_photos PRIMARY KEY (user_id, photo_id),
CONSTRAINT fk_users_photos_users FOREIGN KEY (user_id)
REFERENCES users(id),
CONSTRAINT fk_users_photos_photos FOREIGN KEY (photo_id)
REFERENCES photos(id)
);

CREATE TABLE likes (
id INT PRIMARY KEY AUTO_INCREMENT,
photo_id INT,
user_id INT,
CONSTRAINT fk_photo FOREIGN KEY(photo_id)
REFERENCES photos(id),
CONSTRAINT fk_user FOREIGN KEY (user_id)
REFERENCES users(id)
);

CREATE TABLE comments (
id INT PRIMARY KEY AUTO_INCREMENT,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
photo_id INT NOT NULL,
CONSTRAINT fk_photo_id FOREIGN KEY(photo_id)
REFERENCES photos(id)
);


-- 2.
INSERT INTO addresses(address, town, country, user_id)  
SELECT username, `password`, ip, age FROM users 
WHERE gender = "M";


-- 3.
UPDATE addresses
SET country = (
CASE LEFT(country, 1)
WHEN "B" THEN "Blocked" 
WHEN "T" THEN "Test" 
WHEN "P" THEN "In Progress" 
END
)
WHERE LEFT(country, 1) IN ("B", "T", "P");


-- 4.
DELETE FROM addresses
WHERE id % 3 = 0;


-- 5.
SELECT username, gender, age FROM users
ORDER BY age DESC, username ASC;


-- 6.
SELECT p.id ,c.`date` AS date_and_time, p.`description`, COUNT(c.id) AS `commentsCount` FROM photos AS p
LEFT JOIN comments AS c
ON p.id = c.photo_id
GROUP BY p.id
ORDER BY `commentsCount` DESC, p.id ASC
LIMIT 5;


-- 7.
SELECT concat_ws(" ", u.id, u.username) AS `id_username`, u.email FROM users AS u
JOIN users_photos AS up
ON u.id = up.user_id
WHERE u.id = up.photo_id
ORDER BY u.id;

