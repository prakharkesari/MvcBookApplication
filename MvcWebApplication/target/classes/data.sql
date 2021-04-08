insert into users (id, username, password, name, useraddress, useremail)
values (nextval('seq_users_id'),'emildam','pirata99','Emiliano','ITALY', 'emildam@libero.it');

insert into users (id, username, password, name, useraddress, useremail)
values (nextval('seq_users_id'),'terry','emiliano','Teresa','ITALY', 'terry.c79@gmail.com');

insert into books (bookid, title, author)
values (nextval('seq_books_id'),'Il Silenzio degli innocenti','Pippo');

insert into books (bookid, title, author)
values (nextval('seq_books_id'),'Odissea','Omero');

insert into books (bookid, title, author)
values (nextval('seq_books_id'),'La Divina Commedia','Dante Alighieri');

insert into books (bookid, title, author)
values (nextval('seq_books_id'),'I promessi Sposi','Alessandro Manzoni');

insert into books (bookid, title, author)
values (nextval('seq_books_id'),'Uno Nessuno e Centomila','Luigi Pirandello');

insert into books (bookid, title, author)
values (nextval('seq_books_id'),'Oliver Twist','Oscar Wilde');

insert into rents (rentid, daterent, iduser, idbook)
values (1,current_timestamp,1,1);

insert into rents (rentid, daterent, iduser, idbook)
values (2,current_timestamp,1,2);

insert into rents (rentid, daterent, iduser, idbook)
values (3,current_timestamp,2,3);