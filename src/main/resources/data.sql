create table student
(
  id integer not null,
  name varchar(255) not null,
  email varchar(255) not null,
  primary key(id)
);

insert into student
  (id, name, email)
values
  (1, 'Marian Pazdzioch', 'mikolajkania44@gmail.com'),
  (2, 'Arnold Boczek', 'atthis@o2.pl'),
  (3, 'Ferdynand Kiepski', 'test@test.tt')
;
