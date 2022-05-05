create database movieproject; 


/* 테이블 생성 */
create table movieproject.product(
	pnum int primary key auto-incrment,
	pname varchar(20),
	pprice int,
	psave int
);
