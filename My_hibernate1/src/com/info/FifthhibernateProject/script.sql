--This query is written for sql server
create table StudentAddress
(
Addrss_id int NOT NULL PRIMARY KEY,
Address_Detail varchar(30) NOT NULL
);

INSERT INTO StudentAddress values(1,'NewYork');


--Student table is having a many to one relationship with StudentAddress table
create table Student
(
Student_id int NOT NULL PRIMARY KEY,
Student_name varchar(30) NOT NULL,
Addrss_id int NOT NULL,
FOREIGN KEY (Addrss_id) REFERENCES StudentAddress(Addrss_id)
);

INSERT INTO Student values(101,'Kunal',1);

select * from StudentAddress;
select * from Student;