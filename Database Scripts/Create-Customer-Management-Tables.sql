CREATE DATABASE  IF NOT EXISTS `customer_management`;
USE `customer_management`;

-- Table structure for table `customer`
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- Data for table `customer'
INSERT INTO `customer` VALUES 
	(1,'Mrinal','Mayank','Dakshin Marg','House No. 11','Mumbai','Maharashtra','mrinal@example.com','7858832086'),
    (2, 'John', 'Smith', '123 Main St', 'Apt 5', 'Anytown', 'CA', 'john.smith@example.com', '5551234567'),
    (3, 'Emily', 'Johnson', '456 Elm St', 'Unit 10', 'Cityville', 'NY', 'emily.johnson@example.com', '5559876543'),
    (4, 'Michael', 'Brown', '789 Oak Ave', 'Suite 3', 'Townsville', 'TX', 'michael.brown@example.com', '5555555555'),
    (5, 'Sarah', 'Davis', '987 Pine Rd', 'Apartment 7B', 'Villagetown', 'FL', 'sarah.davis@example.com', '5557778888'),
    (6, 'Christopher', 'Wilson', '654 Maple Ln', 'House No. 9', 'Hamletown', 'WA', 'christopher.wilson@example.com', '5554443333'),
    (7, 'Jessica', 'Lee', '321 Birch Blvd', 'Unit 15', 'Suburbia', 'AZ', 'jessica.lee@example.com', '5552221111'),
    (8, 'David', 'Anderson', '876 Cedar Dr', 'Apartment 12C', 'Metropolis', 'IL', 'david.anderson@example.com', '5559990000'),
    (9, 'Laura', 'Martinez', '789 Pineapple Ct', 'House No. 6', 'Uptown', 'TX', 'laura.martinez@example.com', '5556667777'),
    (10, 'James', 'Kim', '654 Orange St', 'Unit 3', 'Downtown', 'CA', 'james.kim@example.com', '5555439876'),
    (11, 'Amanda', 'Brown', '321 Banana Ave', 'Apartment 8', 'Suburbia', 'FL', 'amanda.brown@example.com', '5551235432'),
    (12, 'Daniel', 'Garcia', '876 Lemon Ln', 'House No. 15', 'Villagetown', 'AZ', 'daniel.garcia@example.com', '5559876789'),
    (13, 'Jennifer', 'Wilson', '987 Strawberry Rd', 'Unit 2A', 'Anytown', 'IL', 'jennifer.wilson@example.com', '5555551111'),
    (14, 'Andrew', 'Clark', '654 Grape Blvd', 'House No. 7', 'Cityville', 'NY', 'andrew.clark@example.com', '5558883333'),
    (15, 'Olivia', 'White', '321 Cherry Ct', 'Apartment 6D', 'Hamletown', 'WA', 'olivia.white@example.com', '5552227777'),
    (16, 'Matthew', 'Turner', '876 Plum Ln', 'Unit 11', 'Townsville', 'TX', 'matthew.turner@example.com', '5554449999');



DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `users`;


-- Table structure for table `users` to manage customers
CREATE TABLE `users` (
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`email`)
);


-- Creating users to manage customers
INSERT INTO `users` VALUES
('test@sunbasedata.com','{noop}Test@123',1),
('mrinalmayank7@gmail.com','{noop}Test@123',1),
('employee@example.com','{noop}Test@123',1);


-- Table structure for table `roles`
CREATE TABLE `roles` (
  `email` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `roles_UK` (`email`,`role`),
  CONSTRAINT `roles_FK` FOREIGN KEY (`email`) REFERENCES `users` (`email`)
);


-- Inserting data for table `roles`
TRUNCATE TABLE roles;
INSERT INTO `roles` VALUES
('test@sunbasedata.com','ROLE_ADMIN'),
('test@sunbasedata.com','ROLE_MANAGER'),
('test@sunbasedata.com','ROLE_EMPLOYEE'),
('mrinalmayank7@gmail.com','ROLE_MANAGER'),
('mrinalmayank7@gmail.com','ROLE_EMPLOYEE'),
('employee@example.com','ROLE_EMPLOYEE');
