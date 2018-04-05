Create table STUDENT
(
student_id number(10) NOT NULL,
student_name varchar2(50) NOT NULL,
PRIMARY KEY (student_id)
)


Create table STUDENT_DETAIL
(
student_id number(10) NOT NULL,
student_mobile_number varchar2(50) NOT NULL,
FOREIGN KEY(student_id) REFERENCES STUDENT(student_id)
)

INSERT into STUDENT values(1,'Kunal');
select * from STUDENT
INSERT into STUDENT_DETAIL values(1,'9560591740');
select * from STUDENT_DETAIL
