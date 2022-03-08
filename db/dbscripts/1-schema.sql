drop sequence if exists book_id_seq;
create sequence book_id_seq increment by 50;

drop table if exists book;

create table book
(
    id          bigint not null primary key,
    title       varchar(500)
);
