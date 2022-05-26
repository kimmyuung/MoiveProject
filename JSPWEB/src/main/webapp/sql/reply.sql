create table jspweb.reply (
rno int primary key auto_increment,
rcontent varchar(100),
rdate datetime default now(),
rindex int,
bno int ,
mno int ,
foreign key(bno) references board(bno) ON UPDATE CASCADE ON DELETE CASCADE,
foreign key(mno) references member(mno) ON UPDATE CASCADE ON DELETE CASCADE
)