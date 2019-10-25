public class Departamento{
	private int idDepartamento;
	private String nomeDepartamento;
	private String localDepartamento;
	private String telefoneDepartamento;
	private Funcionario funcionario;
	//arrayList de saidaProduto

	public Departamento(int idDepartamento, String nomeDepartamento, String localDepartamento, String telefoneDepartamento, Funcionario funcionario) {
		setIdDepartamento(idDepartamento);
		setNomeDepartamento(nomeDepartamento);
		setLocaDepartamento(localDepartamento);
		setTelefoneDepartamento(telefoneDepartamento);
		setFuncionario(funcionario);
	}
	
	//Métodos Get
	public int getIdDepartamento(){
	      return idDepartamento;
	}
	
	public String getNomeDepartamento(){
	      return nomeDepartamento;
	}
	
	public String getLocaDepartamento(){
	      return localDepartamento;
	}
	
	public String getTelefoneDepartamento(){
	      return telefoneDepartamento;
	}
			
	 public Funcionario funcionario(){
		 return funcionario;
	    }
	
	//MÃ©todos set
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	
	public void setLocaDepartamento(String LocalDepartamento) {
		this.localDepartamento = LocalDepartamento;
	}
	
	public void setTelefoneDepartamento(String telefoneDepartamento) {
		this.telefoneDepartamento = telefoneDepartamento;
	}
	
	public void setFuncionario(Funcionario funcionario) {
    	this.funcionario = funcionario;
    }
}
