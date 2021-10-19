ALTER TABLE `products`
ADD CONSTRAINT `my_categories_fk`
FOREIGN KEY (`categories_id`)
REFERENCES `categories` (`id`)
ON DELETE RESTRICT
ON UPDATE CASCADE;