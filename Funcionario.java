public class Funcionario{
	private String cpfFuncionario;
	private String nomeFuncionario;
	private int senhaFuncionario;
	//arrayList de saidaProduto

	public Funcionario(String cpfFuncionario, String nomeFuncionario, int senhaFuncionario) {
		setCPFFuncionario(cpfFuncionario);
		setNomeFuncionario(nomeFuncionario);
		setSenhaFuncionario(senhaFuncionario);
	}
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	//M�todos Get
	public String getCPFFuncionario(){
	      return cpfFuncionario;
	}
	
	public String getNomeFuncionario(){
	      return nomeFuncionario;
	}
	
	public int getSenhaFuncionario(){
	      return senhaFuncionario;
	}
	
	
	//Métodos set
	public void setCPFFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}
	
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public void setSenhaFuncionario(int senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}
	
}

