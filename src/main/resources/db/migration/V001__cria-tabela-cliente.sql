-- Active: 1665228796265@@127.0.0.1@3306@api_algalog
create table cliente (
	id bigint not null auto_increment,
	nome varchar(60) not null,
	email varchar(255) not null,
	telefone varchar(20) not null,
	
	primary key (id)
);