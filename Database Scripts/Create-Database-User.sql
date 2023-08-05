-- Drop user first if they exist
DROP USER if exists 'customeradmin'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'customeradmin'@'localhost' IDENTIFIED BY 'Test@123';
GRANT ALL PRIVILEGES ON * . * TO 'customeradmin'@'localhost';