package model;
public class Produto {
	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private int pesoProduto;

	public Produto (String nomeProduto, String descricaoProduto, int pesoProduto) {
		setNomeProduto(nomeProduto);
		setDescricaoProduto(descricaoProduto);
		setPesoProduto(pesoProduto);		
	}

	public Produto() {
		// TODO Auto-generated constructor stub
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
	
	public int getPesoProduto(){
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

	public void setPesoProduto(int pesoProduto) {
		this.pesoProduto = pesoProduto;
	}	

	public String toString(){
		return "Foi cadastrado o produto com nome do produto: " + getNomeProduto() + " com a descri��o: " + getDescricaoProduto() + " com o peso: " + Integer.toString(getPesoProduto());
	}
}