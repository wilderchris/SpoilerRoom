truncate p_user cascade;
truncate user_rank cascade;
alter sequence p_user_user_id_seq restart;
alter sequence user_rank_rank_id_seq restart;

insert into user_rank(id, rank_title)
values (default, 'User');
insert into user_rank(id, rank_title)
values (default, 'Critic');
insert into user_rank(id, rank_title)
values (default, 'Admin');

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Chris','Wilder','cwilder','admin', 3);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Dana','Jenkins','djenkins','admin', 3);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Andre','Levan','alevan','admin', 3);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Romeo','Erazo','rerazo','admin', 3);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Roger','Ebert','rebert','pass', 2);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Gene','Siskel','gsiskel','pass', 2);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'John','McClane','yippykiyay','pass', 1);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Peter','Venkman','buster','pass', 1);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Seymour','Krelborn','iloveplants','pass', 1);

insert into p_user(id, first_name, last_name, username, passwd, rank_id)
values (default,'Ellen','Ripley','nukeitfromorbit','pass', 1);