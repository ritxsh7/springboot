	create table student(regno int, name varchar(20), subject varchar(20), marks int);

insert into student(regno, name, subject, marks) values
(101, 'Ritesh', 'CSE', 90),
(103, 'Sanket', 'IT', 95);

select * from student;

alter table student add constraint unique_regno unique(regno);