CREATE DATABASE  IF NOT EXISTS web_customer_tracker CHARACTER SET UTF8;
USE web_customer_tracker;


CREATE TABLE customer (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL
) ENGINE=InnoDB;


INSERT INTO customer VALUES 
	('Brian','Kernighan','kernighan@example.com'),
	('James','Gosling','gosling@example.com'),
	('Guido','vanRossum','vanRossum@example.com');

