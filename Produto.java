public class Produto extends Fornecedor {
	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private String setorProduto;
	private String pesoProduto;
	
	public Produto ( int idFornecedor, String nome, String telefone, String endereco, String cnpj, //super
				int idProduto, String nomeProduto, String descricaoProduto, 
				String setorProduto, String pesoProduto) {
		super(idFornecedor, nome, telefone, endereco, cnpj); //super
		setIdProduto(idProduto);
		setNomeProduto(nomeProduto);
		setDescricaoProduto(descricaoProduto);
		setSetorProduto(setorProduto);
		setIPesoProduto(pesoProduto);		
	}

	public int getIdProduto(){
	      return idProduto;
	}
	
	public String getNomeProduto(){
	      return nomeProduto;
	}
	
	public String getDescricaoProduto(){
	      return descricaoProduto;
	}
	
	public String getSetorProduto(){
	      return setorProduto;
	}
	
	public String getPesoProduto(){
	      return pesoProduto;
	}

	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	public void setSetorProduto(String setorProduto) {
		this.setorProduto = setorProduto;
	}
	
	public void setIPesoProduto(String pesoProduto) {
		this.pesoProduto = pesoProduto;
	}	
}
