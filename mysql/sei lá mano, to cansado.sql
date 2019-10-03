create database simetec;
use simetec;
CREATE TABLE Fornecedor (
    id_Fornecedor INT PRIMARY KEY AUTO_INCREMENT,
    nome_fornecedor VARCHAR(80) NOT NULL,
    telefone_fornecedor VARCHAR(80) NOT NULL,
    endereco VARCHAR(80) NOT NULL,
    cnpj VARCHAR(80)
);

CREATE TABLE Produto (
    id_produto INT PRIMARY KEY AUTO_INCREMENT,
    nome_produto VARCHAR(80) NOT NULL,
    descricao_produto VARCHAR(80) NOT NULL,
    setorProduto VARCHAR(80) NOT NULL,
    pesoProduto VARCHAR(80) NOT NULL,
    fornecedor_id INT NOT NULL,
    FOREIGN KEY (fornecedor_id)
        REFERENCES Fornecedor (id_Fornecedor)
);

create table EntradaProduto(
	id_entrada_produto INT PRIMARY KEY AUTO_INCREMENT,
    dataEntrada datetime,
    Produto_id INT NOT NULL,
    FOREIGN KEY (Produto_id)
        REFERENCES Produto (id_Produto)
);

CREATE TABLE Estoque (
    id_estoque INT PRIMARY KEY AUTO_INCREMENT,
    quantidadeEstoque VARCHAR(80) NOT NULL,
    entrada_produto_id INT NOT NULL,
    FOREIGN KEY (entrada_produto_id)
        REFERENCES EntradaProduto (id_entrada_produto)
);