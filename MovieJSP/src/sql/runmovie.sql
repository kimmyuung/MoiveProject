create database movieproject; 


/* 테이블 생성 */
create table movieproject.runtime(
	rno int foreign key,
	rtitle varchar(50),
	rtime datetime(30),
	rtheater varchar(30)
);
