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

select * from students;

select * from addresses;

select * from students where stud_id = 1;

delete from students where name = '배준열';

select stud_id, name, email, phone, a.addr_id, street, city, state, zip, country
		from students s left outer join addresses a on s.addr_id=a.addr_id
		where stud_id=1;
		
select stud_id, name email, phone, a.addr_id, street, city, state, zip, country
from students s left join addresses a on s.ADDR_ID = a.ADDR_ID
where stud_id=1;

select t.tutor_id, t.name as tutor_name, email, c.course_id, c.name, description,
		start_date, end_date
		from tutors t left join addresses a on t.addr_id = a.addr_id
			left join courses c on t.TUTOR_ID = c.TUTOR_ID
		where t.TUTOR_ID = 1;
		
		
select * from courses where tutor_id=1;
