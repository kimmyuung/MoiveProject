create table plike (
plikeno int primary key auto_increment,
pno int,
mno int,
foreign key(pno) references product(pno) on delete cascade,
foreign key(mno) references member(mno) on delete cascade

)