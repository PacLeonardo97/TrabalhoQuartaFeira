package model;
public class Departamento{
	private int idDepartamento;
	private String nomeDepartamento;
	private String localDepartamento;
	private Funcionario funcionario;
	//arrayList de saidaProduto

	public Departamento(String nomeDepartamento, String localDepartamento, Funcionario funcionario) {
		setNomeDepartamento(nomeDepartamento);
		setLocaDepartamento(localDepartamento);

		setFuncionario(funcionario);
	}
	
	//M�todos Get
	public int getIdDepartamento(){
	      return idDepartamento;
	}
	
	public String getNomeDepartamento(){
	      return nomeDepartamento;
	}
	
	public String getLocaDepartamento(){
	      return localDepartamento;
	}
				
	public Funcionario funcionario(){
		 return funcionario;
	}
	
	//Métodos set
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	
	public void setLocaDepartamento(String LocalDepartamento) {
		this.localDepartamento = LocalDepartamento;
	}

	public void setFuncionario(Funcionario funcionario) {
    	this.funcionario = funcionario;
    }
}