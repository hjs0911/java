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

insert into employee values('a001','배준열','부장','A');
insert into employee values('a235','시험대','대리','B');
insert into employee values('a236','시험소','대리','C');
insert into client values('a324','3421','시험임','H');
insert into client values('a325','3422','김철수','L');
insert into bankbook values('345-343','a324',20151124,3.3,500000);
insert into bankbook values('345-344','a325',20151125,3.3,0);

delete from bankbook;

select *from bankbook;

select * from client;
select * from employee;
select * from bankbook;
delete from bankbook where accountnumber='345-344';

select b.accountnumber, b.cltcode, c.cltname from bankbook b, client c where c.cltcode=b.cltcode;
select accountnumber, cltcode, cltname from bankbook b, client c where c.cltcode=b.cltcode;
select cltpass from client where cltname='시험임';
select cltname from client where cltpass='3421';

update bankbook set balance = balance+20000 where accountnumber='345-343';
select balance from bankbook where accountnumber='345-343';

insert into trnhistory values('a234','345-343','I','2015-12-14',500000,600000);
insert into trnhistory values('a234','345-343','I','2015-12-14',500000,600000);

select * from trnhistory;

create view v_inter as
select accountnumber, interestrate, c.cltcode, cltgrade, balance, 
round(balance + (balance*(0.01*interestrate+
(case
	when cltgrade = 'H' then 0.01
	when cltgrade = 'M' then 0.005
	else 0
end))), 0) as 수정잔액
from bankbook b, client c
where b.cltcode = c.cltcode;

drop view v_inter;

select * from v_inter;
delete from trnhistory where empcode='a234';

drop database bank;

update bankbook set balance=0 where accountnumber='345-343';
update bankbook set balance=0 where accountnumber='345-344';
select c.cltname, balance + (balance*(0.01*interestrate+
(case
	when cltgrade = 'H' then interestrate*0.01
	when cltgrade = 'M' then interestrate*0.005
	else 0
end))) as 수정잔액
from bankbook b, client c
where b.cltcode = c.cltcode;

update bankbook b, client c set balance=balance + (balance*(0.01*interestrate+
(case
	when cltgrade = 'H' then interestrate*0.01
	when cltgrade = 'M' then interestrate*0.005
	else 0
end)))
where b.cltcode = c.cltcode;

CREATE view nowbankbook as
select b.accountnumber, c.cltcode, c.cltname, b.openingdate, b.interestrate, b.balance
from bankbook b,client c
where b.cltcode = c.cltcode;
select balance,cltgrade,interestrate from bankbook b, client c where accountnumber='345-343' and b.cltcode = c.cltcode;
select accountnumber from bankbook b, client c where b.cltcode = c.cltcode;
select balance,cltgrade,interestrate from bankbook b, client c where accountnumber='345-343' and b.cltcode = c.cltcode;
select * from trnhistory;
delete from trnhistory;

CREATE view DaysTrnHistorys as
select trndate,accountnumber,case when trntype ='I' then trnmoney else '0' end as 'INPUT', case when trntype ='D' then trnmoney else '0' end as 'OUTPUTS'
from trnhistory 
ORDER by trndate desc;