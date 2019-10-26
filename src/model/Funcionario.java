package model;
import br.com.parg.politicaDeFoco.Criptografia;

public class Funcionario{
	private String cpfFuncionario;
	private String nomeFuncionario;
	private String senhaFuncionario;
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
	public String getCPFFuncionario(){
	      return cpfFuncionario;
	}
	
	public String getNomeFuncionario(){
	      return nomeFuncionario;
	}
	
	public String getSenhaFuncionario(){
	      return senhaFuncionario;
	}
	
	
	//MÃ©todos set
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
	
	public String toString() {
		return getNomeFuncionario() + " com o nome: " + getNomeFuncionario() + "com a senha: " + getSenhaFuncionario();
	}
}

