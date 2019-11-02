package model;

import java.util.Date;

public class Produto {
	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private int pesoProduto;
	private Date dataCriacao;

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
	
	public Date getDataCriacao(){
	      return dataCriacao;
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
	
	public void setDataCriacao(Date dataCriacao){
		this.dataCriacao = dataCriacao;
	}

	public String toString(){
		return getNomeProduto();
	}
	
}
