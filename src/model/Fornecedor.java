package model;
public class Fornecedor {

	private String nome;
	private String telefone;
	private String cnpj;
	private int idFornecedor;
	
	public Fornecedor(String nome, String telefone, String cnpj){	
		setNome(nome);
		setTelefone(telefone);
		setCNPJ(cnpj);
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
	
	public String toString(){
		return getNome() + " com o telefone: " + getTelefone() + " e o CNPJ"+ getCNPJ()+ ",";
	}
}


