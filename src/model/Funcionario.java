package model;
import java.util.Date;

import br.com.parg.politicaDeFoco.Criptografia;

public class Funcionario{
	private int id;
	private String cpfFuncionario;
	private String nomeFuncionario;
	private String senhaFuncionario;
	private Date data;
	//arrayList de saidaProduto

	public Funcionario(String cpfFuncionario, String nomeFuncionario, String senhaFuncionario) {
		setCPFFuncionario(cpfFuncionario);
		setNomeFuncionario(nomeFuncionario);
		setSenhaFuncionario(senhaFuncionario);
	}
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	//Métodos Get
	public int getidFunc(){
	      return id;
	}
	
	public String getCPFFuncionario(){
	      return cpfFuncionario;
	}
	
	public String getNomeFuncionario(){
	      return nomeFuncionario;
	}
	
	public String getSenhaFuncionario(){
	      return senhaFuncionario;
	}
	
	public Date getData() {
		return data;
	}
	
	
	//MÃ©todos set
	public void setIduncionario(int id) {
		this.id = id;
	}
			
	public void setCPFFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}
	
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public void setSenhaFuncionario(String senhaFuncionario) {
		Criptografia criptografia = new Criptografia();
		String senha = criptografia.Criptografia(senhaFuncionario);
		this.senhaFuncionario = senha;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String toString() {
		return getNomeFuncionario() + " com o nome: " + getNomeFuncionario() + "com a senha: " + getSenhaFuncionario();
	}
}

