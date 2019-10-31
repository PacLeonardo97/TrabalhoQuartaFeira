package model;
import java.util.Date;

public class EntradaProduto{
	
	private int idEntradaProduto;
	private Date dataEntrada;
	private int quantidade;
	private Produto produto;
	private Date dataCriada;
	
	public EntradaProduto(Date data, int quantidade, Produto produto){
		setDataEntrada(data);
		setQuantidade(quantidade);
		setProduto(produto);
	}
	
	public int getIdEntradaProduto(){
	    return idEntradaProduto;
	}
	
	public Date getDataEntrada(){
	    return dataEntrada;
	}
	
	public int getQuantidade(){
	    return quantidade;
	}
	
	public Date getDataCriada(){
	    return dataCriada;
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

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setDataCriada(Date dataCriada) {
		this.dataCriada = dataCriada;
	}
	public void setProduto(Produto produto) {
		
		this.produto = produto;
	}

	public String toString(){
		return " Id Entrada Produto: " + idEntradaProduto;
	}
}
