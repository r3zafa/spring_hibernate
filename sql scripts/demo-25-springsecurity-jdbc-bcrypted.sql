CREATE DATABASE  IF NOT EXISTS `springmvc_security_demo_jdbc_bcrypt` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `springmvc_security_demo_jdbc_bcrypt`;


-- users -------------------------------------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE USERS (
    `username` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `password` VARCHAR(68) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- INSERT into users ------------------------------------------
INSERT INTO `users`
VALUES ('admin','admin@spring.com','{bcrypt}$2a$10$A0oFVc1Qt97Xhpsh2SP7NuunRT5UEYRrg4fgQwk7LxVey/ZrskB6q',1), 
	   ('reza','reza@spring.com','{bcrypt}$2a$10$Lcu8DrY0VRFdXPmBiAIItOmf7rVRKh/k2wwO6CRGNIdoAlFVE3eD6',1), 
       ('frobese','frobese@frobese.com','{bcrypt}$2a$10$KqnvUfdfCBYMDjcPBRHbPuJVSs6XqqVROEXHwOhixJT4aViSd0AZe',1);


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

