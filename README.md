# MyBLog

The project includes functionalities like signup, sign in, post blogs and view blogs. Users can register for the website by providing their details. While signup he gives username and password of his choice. Using the username and password, user can login into the website. After logging in, users can post a blog. Users can also see all the blogs posted by other users.

#SETUP INSTRUCTIONS
1. Download and unzip the project on your local drive.
2. Download MySQL from http://dev.mysql.com/downloads/installer/
3. Got to MySQL Workbench, create a new connection in which username is “root” and password is “piyu”.
4. Create a schema named “blogs”.
5. Run the sql query “use blogs;”
6. Inside the schema “blogs” create two tables named “blog” and “user”.
7. Create table “blog” using following query:
CREATE TABLE `blogs`.`blog` (
`id` INT NOT NULL AUTO_INCREMENT,
`author` VARCHAR(45) NULL,
`blog` VARCHAR(1000) NULL,
`created` VARCHAR(45) NULL,
PRIMARY KEY (`id`));
8. Create table user using following query:
CREATE TABLE `blogs`.`user` (
`id` INT NOT NULL AUTO_INCREMENT,
`fname` VARCHAR(45) NULL,
`lname` VARCHAR(45) NULL,
`username` VARCHAR(45) NULL,
`password` VARCHAR(45) NULL,
PRIMARY KEY (`id`));
9. A command.sql file is also attached with the project.
10. In the command prompt of the project folder type: mvn clean .
11. Run the mvn package this will create a war in the target subdirectory of the project.
12. Start the tomcat server by Startup.bat command.
13. Deploy the war file to the tomcat manager or copy the war file in the webapps folder of tomcat.
14. Go to this url => http://localhost:8081/blog/ (if your server runs on port 8080, do http://localhost:8080/blog/).
