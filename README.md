# ATM

Demo: http://atm-app.unicloud.pl/ 
(test data http://i.piccy.info/i9/0bdd2076da92a081d7e4fd5568db1b47/1436455705/15347/928160/TestData_Capture.png)

ScreenShots:
- http://i.piccy.info/i9/68e90772a139722303775c622e8c5636/1436420775/27806/927959/1.png
- http://i.piccy.info/i9/bee778a77b7a984e22fb6255db50dbef/1436420805/24736/927959/2.png
- http://i.piccy.info/i9/546555f625dd9da1d68b093eab9b7e21/1436420842/21647/927959/3.png
- http://i.piccy.info/i9/30882dfca6d9d192d6332c884acd4f37/1436420853/22193/927959/4.png
- http://i.piccy.info/i9/be917585e99a6a4d45dfc0ca66a578a6/1436420872/28279/927959/5.png
- http://i.piccy.info/i9/d66167d5ef485e79b6f2bbbc69c20bc6/1436420892/24799/927959/6.png

Technologies used:
- Java
- Spring MVC
- Spring IoC
- Hibernate
- MySQL
- JSP
- JavaScript
- jQuery
- Bootstrap


What can be improved:
- Add using of Spring Security and encryption of pin code when it transferring between server and ui side
 
To run application you need to add MySQL database configuration in file jdbc.properties

To create database and tables you can use this queries:
CREATE DATABASE `DATABASE_NAME` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `DATABASE_NAME`;

CREATE USER 'USERNAME'@'localhost' IDENTIFIED BY 'PASSWD';
CREATE USER 'USERNAME'@'%' IDENTIFIED BY 'PASSWD';
GRANT ALL ON `DATABASE_NAME`.* TO 'USERNAME'@'localhost';
GRANT ALL ON `DATABASE_NAME`.* TO 'USERNAME'@'%';

In datasource-context.xml set in property hibernate.hbm2ddl.auto value "create" and hibernate creates tables in accordance with the entities after application start.

To add some test data use this query:
INSERT INTO `CARD`(`NUMBER`, `BALANCE`, `INVALID_PIN_ATTEMPTS_COUNT`, `IS_BLOCKED`, `PIN_NUMBER`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])

INSERT INTO `OPERATION`(`id`, `AMOUNT_WITHDRAWN`, `CODE`, `DATE`, `NUMBER`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])
