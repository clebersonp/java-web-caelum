-- criacao da tabela de contatos
create table contatos (
	id bigint not null auto_increment,
    nome varchar(255),
    email varchar(255),
    endereco varchar(255),
    dataNascimento date,
    primary key (id)
);

-- criacao da tabela de tarefas
CREATE TABLE tarefas (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  descricao varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  finalizado boolean,
  dataFinalizado date DEFAULT NULL,
  PRIMARY KEY (id)
);

select * from tarefas;

-- update tarefas set finalizado = 1 where id = 1;


-- criar a tabela de usuarios
CREATE TABLE usuarios (
	login VARCHAR(255),
    senha VARCHAR(255)
);

insert into usuarios values ('cleberson', 1234);

select * from usuarios;


