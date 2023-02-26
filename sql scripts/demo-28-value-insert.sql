USE `demo28`;
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