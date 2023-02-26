CREATE DATABASE  IF NOT EXISTS `springmvc_security_demo_jdbc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `springmvc_security_demo_jdbc`;


-- users -------------------------------------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE USERS (
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- INSERT into users ------------------------------------------
INSERT INTO `users`
VALUES ('admin','{noop}admin',1), ('reza','{noop}reza',1), ('frobese','{noop}frobese',1);


-- authorities ------------------------------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE AUTHORITIES (
    `username` VARCHAR(50) NOT NULL,
	`authority` VARCHAR(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
    CONSTRAINT `authorities_ibfk_1`
    FOREIGN KEY (`username`)
    REFERENCES `users` (`username`)
    );


-- INSERT into ROLES ------------------------------------------
INSERT INTO `authorities`
VALUE 
('admin','ROLE_ADMIN'),('admin','ROLE_USER'),
('reza','ROLE_USER'),
('frobese','ROLE_MANAGER'),('frobese','ROLE_USER');

