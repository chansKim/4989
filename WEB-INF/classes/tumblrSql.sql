create database chan DEFAULT CHARACTER SET utf8 collate utf8_general_ci ;

CREATE table member (
	m_mail varchar(20),
	m_password varchar(48) NOT NULL,
	m_name varchar(20),
	m_main_photo int default '-1',
	m_back_photo int default '-1',
    m_main_mention varchar(100) default NULL,
	m_phone varchar(20),
	ctime datetime NOT NULL,
	mtime datetime NOT NULL,
 	PRIMARY KEY(m_mail)
);

CREATE table uploadResource (
   	r_id int not null auto_increment,
	m_mail varchar(20),
	r_name varchar(100),
	r_title varchar(30),
	k_name int,
	r_type int(1),
	post_type varchar(1),
	number_type int(1),
	r_content text default null,
	ctime datetime NOT NULL,
	mtime datetime NOT NULL,
 	PRIMARY KEY(r_id)
);

CREATE TABLE reply(
	id INT AUTO_INCREMENT ,
	r_id int NOT NULL,
	ctime datetime NOT NULL,
	mtime datetime NOT NULL,
	m_mail VARCHAR( 20 ) ,
	content VARCHAR( 100 ) ,
	secretType int,
	PRIMARY KEY ( id )
);

CREATE TABLE like_product(
	l_id int auto_increment,
	r_id int NOT NULL,
	m_mail varchar(20),
	ctime datetime NOT NULL,
	mtime datetime NOT NULL,
   	primary key(l_id)
);

create table follow(
	f_id int auto_increment,
	m_mail varchar(20) NOT NULL,
	face_mail varchar(20) default NULL,
	k_name varchar(20) default null,
	ctime datetime NOT NULL,
	mtime datetime NOT NULL,
	primary key(f_id)
);

create table note(
	n_id int auto_increment,
	m_mail varchar(20) NOT NULL,
	face_mail varchar(20) NOT NULL,
	n_content text not null,
	readType int,
	ctime datetime NOT NULL,
	mtime datetime NOT NULL,
	primary key(n_id)
);

create table errorReport(
	e_id int auto_increment,
	m_mail varchar(20) NOT NULL,
	r_id int,
	e_content text not null,
	ctime datetime NOT NULL,
	mtime datetime NOT NULL,
	primary key(e_id)
);

