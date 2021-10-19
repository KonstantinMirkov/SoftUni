DROP PROCEDURE IF EXISTS usp_get_older;
DELIMITER $$
CREATE PROCEDURE usp_get_older (minion_id INT)
BEGIN
UPDATE minions
SET age = age + 1
WHERE id = minion_id;
END $$
DELIMITER ;

CALL usp_get_older(1);

