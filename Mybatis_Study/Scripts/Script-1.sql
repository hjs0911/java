drop table student;

create TABLE student(
	stud_id int(11) not null auto_increment,
	name VARCHAR(50) not null,
	email VARCHAR(50) not null,
	phone VARCHAR(15) not null,
	dob date DEFAULT null,
	PRIMARY KEY (stud_id)
);

show tables;

insert into student values
(1, 'student1', 'student1@gmail.com', '010-1234-5678', '1983-06-25'),
(2, 'student2', 'student2@gmail.com', '010-1234-5678', '1983-06-25');

select * from student;

select * from student where stud_id = 1;

delete from student where name = '배준열';

