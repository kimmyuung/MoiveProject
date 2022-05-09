create database movieproject; 


/* 테이블 생성 */
create table movieproject.movie( /*한국영화진흥원에서 데이터 가져올 예정이라 필요없을 수도 있음*/
	mnum int primary key, auto_increment,
	mtitle varchar(50),
	mruntime datetime /* 분 단위로 저장 */
	
);
