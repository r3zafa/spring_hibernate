DROP DATABASE IF EXISTS `demo28`;
CREATE DATABASE `demo28`;
USE `demo28`;
-- Drop existings ----------------------------------------------
DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `authorities`;
-- customer ----------------------------------------------------
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
-- users -------------------------------------------------------
CREATE TABLE `users` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(68) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
	`first_name` varchar(45) DEFAULT NULL,
	`last_name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`username`),
    UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- authorities ------------------------------------------------
CREATE TABLE `authorities` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50) NOT NULL,
	`authority` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`),
    UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
    CONSTRAINT `authorities_ibfk_1`
    FOREIGN KEY (`username`)
    REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
 
-- INSERT into customers --------------------------------------
INSERT INTO `customer` VALUES 
	(1,'David','Adams','david@frobese.com'),
	(2,'John','Doe','john@frobese.com'),
	(3,'Ajay','Rao','ajay@frobese.com'),
	(4,'Mary','Public','mary@frobese.com'),
	(5,'Maxwell','Dixon','max@frobese.com');
-- INSERT into users ------------------------------------------
INSERT INTO `users` VALUES 
	(1,'admin','{bcrypt}$2a$10$A0oFVc1Qt97Xhpsh2SP7NuunRT5UEYRrg4fgQwk7LxVey/ZrskB6q',1,'Reza','Faraji','rfaraji@frobese.com'), 
	(2,'reza','{bcrypt}$2a$10$Lcu8DrY0VRFdXPmBiAIItOmf7rVRKh/k2wwO6CRGNIdoAlFVE3eD6',1,'Reza','Faraji','rfaraji@frobese.com'), 
	(3,'frobese','{bcrypt}$2a$10$KqnvUfdfCBYMDjcPBRHbPuJVSs6XqqVROEXHwOhixJT4aViSd0AZe',1,'Reza','Faraji','rfaraji@frobese.com');
-- INSERT into ROLES ------------------------------------------
INSERT INTO `authorities` VALUE 
	(1,'admin','ROLE_ADMIN'),(2,'admin','ROLE_EMPLOYEE'),
	(3,'reza','ROLE_EMPLOYEE'),
	(4,'frobese','ROLE_MANAGER'),(5,'frobese','ROLE_EMPLOYEE');
