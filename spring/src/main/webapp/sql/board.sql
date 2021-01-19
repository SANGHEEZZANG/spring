-- 스프링 게시판
drop table board purge;

select * from tab;
select * from seq;
select * from board;

create table board(
	  no number primary key,
	  writer varchar2(20),
      passwd varchar2(20),
	  subject varchar2(50),
	  content varchar2(100),
	  readcount number,
	  register date );
	  
create sequence board_seq;	  