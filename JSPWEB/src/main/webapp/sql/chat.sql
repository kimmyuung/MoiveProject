create table jspweb.chat (
cno int primary key auto_increment,
cname varchar(100),
ccontent varchar(100),
cdate datetime default now()
)