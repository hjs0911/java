create database bank;
use bank;
create table employee(
	empcode char(4) primary key,
	empname varchar(9),
	emptitle varchar(9),
	empauth char(1)
);

create table client(
	cltcode char(4) primary key,
	cltpass char(4),
	cltname varchar(9),
	cltgrade char(1)
);

create table bankbook(
	accountnumber char(7) primary key,
	cltcode char(4),
	openingdate date,
	interestrate double,
	balance int(13)
);

create table trnhistory(
	empcode char(4),
	accountnumber char(7),
	trntype char(1),
	trndate date,
	trnmoney int(13),
	balance int(13)
);

drop table employee;
drop table bankbook;
drop table trnhistory;

drop database bank;

insert into employee values('a234','시험중','대리','A');
insert into employee values('a235','시험대','대리','B');
insert into employee values('a236','시험소','대리','C');
insert into client values('a324','3421','시험임','H');
insert into bankbook values('345-343','a324',20151124,3.3,500000);

select *from bankbook;

select * from client;
select * from employee;
select * from bankbook;
delete from client where cltcode='a101';

select b.accountnumber, b.cltcode, c.cltname from bankbook b, client c where c.cltcode=b.cltcode;
select accountnumber, cltcode, cltname from bankbook b, client c where c.cltcode=b.cltcode;
select cltpass from client where cltname='시험임';
select cltname from client where cltpass='3421';

update bankbook set balance = balance+20000 where accountnumber='345-343';
select balance from bankbook where accountnumber='345-343';

insert into trnhistory values('a234','345-343','I','2015-12-14',500000,600000);

select * from trnhistory;