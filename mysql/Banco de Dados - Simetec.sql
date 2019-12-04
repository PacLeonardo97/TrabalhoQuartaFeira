create database simetec;
use simetec;

create table simetec.funcionario(
id_func int not null auto_increment primary key,
cpf varchar(80) not null unique,
nome varchar(80) not null,
senha varchar(255) not null,
created_at datetime
);

insert into simetec.funcionario (cpf, nome, senha) values("123456789-00", "josemir","A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3"); -- cpf = 123456789-00, nome = josemir, senha = 123(criptografada)


create table simetec.fornecedor(
id_forn int not null auto_increment primary key,
nome_forn varchar(80) not null,
telefone varchar(80) not null,
cnpj varchar(80) not null,
created_at datetime
);

create table simetec.endereco_forn(
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

create table simetec.produto(
id_prod int not null auto_increment primary key,
nome_produto varchar(80) not null,
Descricao_produto varchar(80) not null,
peso_produto int not null,
created_at datetime
);

create table simetec.entradaProduto(
id_ent_prod int not null auto_increment primary key,
data_entrada date not null,
quantidade int not null,
created_at date,
prod_id int,
foreign key (prod_id) REFERENCES produto(id_prod)
on delete set null
);
insert into simetec.funcionario (cpf, nome, senha, created_at) values("1234", "josemir","03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4", NOW()); -- cpf = 1234, nome = josemir, senha = 1234(criptografada)

create view `saidaProd` as select saidaProduto.id_saida_prod, saidaProduto.data_saida, saidaProduto.quantidade, produto.nome_produto, produto.Descricao_produto, produto.peso_produto , saidaProduto.created_at
from saidaProduto inner join produto on saidaProduto.prod_id = produto.id_prod;


select saidaProduto.id_saida_prod, saidaProduto.data_saida, saidaProduto.quantidade, produto.nome_produto, produto.Descricao_produto, produto.peso_produto , saidaProduto.created_at
from saidaProduto inner join produto on saidaProduto.prod_id = produto.id_prod;

select entradaProduto.data_entrada, entradaProduto.quantidade, produto.nome_produto, produto.Descricao_produto, produto.peso_produto from entradaProduto inner join produto on entradaProduto.prod_id = produto.id_prod;

create view `entProd` as select entradaProduto.id_ent_prod ,entradaProduto.data_entrada, entradaProduto.quantidade, produto.nome_produto, produto.Descricao_produto, produto.peso_produto , entradaProduto.created_at
from entradaProduto inner join produto on entradaProduto.prod_id = produto.id_prod;


select * from entProd;	

create table simetec.saidaProduto(
id_saida_prod int not null auto_increment primary key,
data_saida date not null,
quantidade int not null,
prod_id int,
created_at date,
foreign key (prod_id) REFERENCES Produto(id_prod)
on delete set null
);

create table simetec.departamento(
id_departamento int not null auto_increment primary key,
nome_departamento varchar(80) not null,
local varchar(80) not null,
func_id int,
foreign key (func_id) REFERENCES funcionario(id_func)
on delete set null
);

select departamento.id_departamento, departamento.nome_departamento, departamento.local, funcionario.cpf, funcionario.nome from departamento inner join funcionario on departamento.func_id = funcionario.id_func;
create view `DptoFunc`as select departamento.id_departamento, departamento.nome_departamento, departamento.local, funcionario.cpf, funcionario.nome from departamento inner join funcionario on departamento.func_id = funcionario.id_func;

