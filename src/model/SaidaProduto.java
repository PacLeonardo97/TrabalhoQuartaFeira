package model;
import java.util.Date;
public class SaidaProduto{
	
	private int idSaidaProduto;
	private Date date;
	private int quantidade;
	private Date dataCriada;
	private EntradaProduto produto;
	
	public SaidaProduto( Date data, int quantidade, EntradaProduto produto) {
		setDate(data);
		setQuantidade(quantidade);
		setProduto(produto);
	}
	
	public int getIdSaidaProduto(){
	    return idSaidaProduto;
	}
	
	public Date getDate(){
	    return date;
	}
	
	public int getQuantidade(){
	    return quantidade;
	}
	
	public EntradaProduto getProduto(){
	    return produto;
	}
	
	public Date getDataCriada(){
	    return dataCriada;
	}

	public void setIdSaidaProduto(int idSaidaProduto) {
		this.idSaidaProduto = idSaidaProduto;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setProduto(EntradaProduto produto) {
		this.produto = produto;
	}
	
	public void setDataCriada(Date dataCriada) {
		this.dataCriada = dataCriada;
	}
	
	
	public String toString(){
		return "";
	}
}
