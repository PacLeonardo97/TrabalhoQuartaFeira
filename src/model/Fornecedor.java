package model;

import java.util.Date;
import org.apache.commons.mail.*;

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
		email1();
	}
	
	public Fornecedor() {
		nome = null;
		telefone = null;
		cnpj = null;
		idFornecedor = 0;
	}
	
	private void email1() {
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");  
			email.setAuthentication("pacleonardo97@gmail.com","Guga983838753a");  
			email.setSSL(true);  
			email.addTo("pacleonardo97@gmail.com"); //pode ser qualquer email  
			email.setFrom("pacleonardo97@gmail.com"); //será passado o email que você fará a autenticação
			email.setSubject("Enviando email");  
			email.setMsg("Teste de envio de email"+ " " + nome + " " + telefone + " " + cnpj);  
			email.send();  
			
		} catch (EmailException e) {

			e.printStackTrace();
		}
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


