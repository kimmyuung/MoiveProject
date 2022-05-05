create database movieproject; 


/* 테이블 생성 */
create table movieproject.ticket( /*한국영화진흥원에서 데이터 가져올 예정이라 필요없을 수도 있음*/
	tnum int primary key, auto_increment,
	ttitle varchar(50),
	tstarttime datetime, 
	ttname varchar(30), /*상영관 이름*/
	tpeople int,
	tprice int,
	tseat varchar(10)
);
