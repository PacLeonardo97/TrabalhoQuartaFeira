
public class Departamento extends SaidaProduto {
	private int idDepartamento;
	private String nomeDepartamento;
	private String localDepartamento;
	private String telefoneDepartamento;

	public Departamento(
			int idSaidaProduto, String dataSaidaProduto, //super
			 int idDepartamento, String nomeDepartamento, String localDepartamento, String telefoneDepartamento
			) {
		super(idSaidaProduto, dataSaidaProduto);
		
		setIdDepartamento(idDepartamento);
		setNomeDepartamento(nomeDepartamento);
		setLocaDepartamento(localDepartamento);
		setTelefoneDepartamento(telefoneDepartamento);
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
	
	public void setTelefoneDepartamento(String telefoneDepartamento) {
		this.telefoneDepartamento = telefoneDepartamento;
	}
}
