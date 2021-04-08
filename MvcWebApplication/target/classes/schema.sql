CREATE TABLE users
(
id 			integer 		NOT NULL,
username	varchar(20) 	NOT NULL,
password	varchar(20) 	NOT NULL,
name 		varchar(100) 	NOT NULL,
useraddress	varchar(100) 	NOT NULL,
useremail 	varchar(100) 	NOT NULL,
PRIMARY KEY (id)
);

CREATE SEQUENCE seq_users_id
START 1
INCREMENT 1;

CREATE TABLE books
(
bookid 		integer 		NOT NULL,
title		varchar(100) 	NOT NULL,
author		varchar(100) 	NOT NULL,
PRIMARY KEY (bookid)
);

CREATE SEQUENCE seq_books_id
START 1
INCREMENT 1;

CREATE TABLE rents
(
rentid 		integer 		NOT NULL,
daterent	timestamp	 	NOT NULL,
iduser		integer 		NOT NULL,
idbook		integer 		NOT NULL,
PRIMARY KEY (rentid),
CONSTRAINT fk_user
FOREIGN KEY (iduser)
	REFERENCES users(id),
CONSTRAINT fk_book
FOREIGN KEY (idbook)
	REFERENCES books(bookid)	
);