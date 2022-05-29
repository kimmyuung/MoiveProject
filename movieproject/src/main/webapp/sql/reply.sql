create table movieproject.reply (
rno int primary key auto_increment,
rcontent varchar(100),
rdate datetime default now(),
rindex int,
mno int ,
foreign key(mno) references member(mno) ON UPDATE CASCADE ON DELETE CASCADE
)