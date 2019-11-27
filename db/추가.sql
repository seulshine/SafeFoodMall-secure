select * from food;


ALTER TABLE food ADD (watch int(11) default 0);

use safefood;

create table board (
	no int(11) primary key auto_increment,
    id varchar(30),
    title varchar(100),
	regdate timestamp default current_timestamp on update current_timestamp,
	contents varchar(3000),
	constraint contents_fk foreign key (id) references user(id)
);

select * from food;
desc food;

select * from food;
select * from cart where id= "ssafy" and code = 1;

select * from user;
commit;
select * from history;
    


create table comment (
	comm_no int(11) primary key auto_increment,
    board_no int(11), 
    id varchar(30),
    regdate timestamp default current_timestamp on update current_timestamp,
    comments varchar(3000),
    constraint comments_fk foreign key (board_no) references board(no)
);
select * from board;

insert into board (id, title, contents) values ("ssafy", "첫 인사", "안녕하세요~");

 select * from board where id="ssafy" and no =1;

commit;

use safe;
select * from comment where id="ssafy";

select * from user;
UPDATE board SET title="수정", contents= "수정" WHERE id="ssafy" and no=1;
commit;
insert into comment (board_no, id, comments) values (1, "ssafy", "댓글냠냠");

desc board;
desc comment;

update food set watch=watch+1 where code=1;
commit;
select * from food;


drop table cart;
create table cart ( 
	id varchar(30), -- user id
	code int(11),
    qty int(11),
    constraint pk_cart primary key(id, code),
	constraint fk_cart foreign key (id) references user(id),
	constraint fk2_cart foreign key (code) references food(code)
);

drop table inventory;
create table inventory (
    code int(11),
    instock int not null,
    price int(11) not null,
    constraint pk_inventory primary key (code),
    constraint fk_inventory foreign key (code) references food(code)
);
commit;

insert into inventory values(1,20,1500);
insert into inventory values(2,30,1600);
insert into inventory values(3,22,1800);
insert into inventory values(4,12,1900);
insert into inventory values(5,19,1200);
insert into inventory values(6,21,1300);
insert into inventory values(7,10,1400);
insert into inventory values(8,42,1700);
insert into inventory values(9,33,1300);
insert into inventory values(10,15,2100);
insert into inventory values(11,22,1200);
insert into inventory values(12,23,2300);
insert into inventory values(13,26,4500);
insert into inventory values(14,21,2300);
insert into inventory values(15,22,2100);
insert into inventory values(16,24,2200);
insert into inventory values(17,25,2300);
insert into inventory values(18,26,2100);
insert into inventory values(19,26,2100);
insert into inventory values(20,21,2300);



create table diary ( 
	no int(11) primary key auto_increment,
	year int(5),
	month int(3),
    day int(3),
	meal varchar(30),
    time varchar(30),
    kind varchar(255)
);

commit;




drop table orderlist;



create table orderlist ( 
	regdate timestamp default current_timestamp, #group key
	id varchar(30), -- user id
	code int(11),
    qty int(11),
    img varchar(100),
    name varchar(20),
    price int(11),
	constraint fk_orderlist foreign key(code) references food(code),
	constraint fk2_orderlist foreign key (id) references user(id)
);

commit;
