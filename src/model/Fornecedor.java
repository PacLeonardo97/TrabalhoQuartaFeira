package model;

import java.util.Date;

import handler.SendingEmail;

public class Fornecedor {
	
	private int idFornecedor;
	private String nome;
	private String telefone;
	private String cnpj;
	private Date data;
	
	public Fornecedor(String nome, String telefone, String cnpj){	
		setNome(nome);
		setTelefone(telefone);
		setCNPJ(cnpj);
		SendingEmail.email1("Cadastrado um novo Fornecedor" , "Nome cadastrado: " + nome + " Telefone cadastrado: " + telefone + " CNPJ cadastrado: " +cnpj, "leozinhopachekinho@hotmail.com");
	}
	
	public Fornecedor() {
		nome = null;
		telefone = null;
		cnpj = null;
		idFornecedor = 0;
	}
	
	
	

	//Metodos de acesso - get
	public int getIdFornecedor(){
	      return idFornecedor;
	}
	public String getNome(){
	      return nome;
	}
	
	public String getTelefone(){
	      return telefone;
	}
	

	public String getCNPJ(){
	      return cnpj;
	}
	
	public Date getData() {
		return data;
	}
	
	//metodos modificadores
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String toString(){
		return getNome() + " com o telefone: " + getTelefone() + " e o CNPJ"+ getCNPJ()+ ",";
	}
}


