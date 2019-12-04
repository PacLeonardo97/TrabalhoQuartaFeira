package model;
import java.util.Date;

public class EntradaProduto{
	
	private int idEntradaProduto;
	private Date dataEntrada;
	private Produto produto;
	private int quantidade;
	private Date dataCriada;
	
	public EntradaProduto(Date data, int quantidade, Produto produto){
		setDataEntrada(data);
		setQuantidade(quantidade);
		setProduto(produto);
	}
	public EntradaProduto() {
		
	}
	
	public int getIdEntradaProduto(){
	    return idEntradaProduto;
	}
	
	public Date getDataEntrada(){
	    return dataEntrada;
	}
	
	public Date getDataCriada(){
	    return dataCriada;
	}
	
	public int getQuantidadeProduto() {
		return quantidade;
	}
	
	public Produto getProduto(){
	    return produto;
	}

	public void setIdEntradaProduto(int idEntradaProduto) {
		this.idEntradaProduto = idEntradaProduto;
	}
	
	public void setDataEntrada(Date date) {
		this.dataEntrada = date;
	}

	
	public void setDataCriada(Date dataCriada) {
		this.dataCriada = dataCriada;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setProduto(Produto produto) {
		
		this.produto = produto;
	}

	public String toString(){
		return Integer.toString(getIdEntradaProduto());
	}
}
