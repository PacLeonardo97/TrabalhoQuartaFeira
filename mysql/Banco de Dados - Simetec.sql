create database simetec;
use simetec;

create table Fornecedor(
id_forn int not null auto_increment primary key,
nome_forn varchar(80) not null,
telefone varchar(80) not null,
cnpj varchar(80) not null,
created_at datetime
);

create table endereco_forn(
id_end_forn int not null auto_increment primary key,
estado varchar(80) not null,
cidade varchar(80) not null,
rua varchar(80) not null,
bairro varchar(80) not null,
numero int not null,
cep varchar(80) not null,
forn_id int,
foreign key(forn_id) REFERENCES Fornecedor(id_forn)
on delete set null
);

create table Aluno(
NumAluno int(10) unsigned not null auto_increment primary key,
NomeAluno varchar(80) not null,
EndereçoAluno varchar(80) not null,
CidadeAluno varchar(80) not null,
Telefone varchar(80) not null,
NumCurso int(10) unsigned,
foreign key(NumCurso) REFERENCES Curso(NumCurso)
on delete set null
);

create table produto(
id_prod int not null auto_increment primary key,
nome_produto varchar(80) not null,
Descricao_produto varchar(80) not null,
peso_produto int not null
);

create table entradaProduto(
id_ent_prod int not null auto_increment primary key,
data date not null,
quantidade int not null,
prod_id int,
foreign key (prod_id) REFERENCES produto(id_prod)
on delete set null
);

create table saidaProduto(
id_saida_prod int not null auto_increment primary key,
data date not null,
quantidade int not null,
prod_id int,
foreign key (prod_id) REFERENCES produto(id_prod)
on delete set null
);

create table funcionario(
id_func int not null auto_increment primary key,
cpf varchar(80) not null,
nome varchar(80) not null,
senha varchar(255) not null,
created_at datetime
);

insert into funcionario (cpf, nome, senha) values("123456789-00", "josemir","A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3"); -- cpf = 123456789-00, nome = josemir, senha = 123(criptografada)

create table departamento(
id_departamento int not null auto_increment primary key,
nome_departamento varchar(80) not null,
local varchar(80) not null,
func_id int,
foreign key (func_id) REFERENCES funcionario(id_func)
on delete set null
);

