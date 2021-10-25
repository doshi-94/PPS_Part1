# PPS_Part1
Project Part 1

Project Group 5:

Sujata Gorai - HC6837
Contribution: Database creation, queries and initialization. Included these same queries in Initialization part in sampleSerlet.java file.

Barakha Doshi - HF2435
Contribution: JSP files and Servlet files. User registration, login, validation for password check and its interaction with database. 

How to run:

1.	To execute: the root data must be present in user table. The name of our database is pps. Below is the query to create user table and insert root record:
CREATE TABLE user(
userid VARCHAR(50),
pwd VARCHAR(50),
fname VARCHAR(50),
lname VARCHAR(50),
bday VARCHAR(20),
ppsbal DOUBLE,
dollarbal DOUBLE,
streetnum VARCHAR(10),
street VARCHAR(20),
city VARCHAR(20),
state VARCHAR(20),
zip VARCHAR(5),
PRIMARY KEY ( userid )
) ;
insert into user values('root', 'pass1234', 'root', 'root','01-01-2000',0.00, 0.00, 123, 'abc', 'city', 'abc', 12312);

2.	Run Index.jsp file as it is the main/starting page
