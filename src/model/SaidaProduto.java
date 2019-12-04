package model;
import java.util.Date;
public class SaidaProduto{
	
	private int idSaidaProduto;
	private Date date;
	private Date dataCriada;
	private int quantidade;
	private Produto produto;
	
	public SaidaProduto( Date data, int quantidade, Produto produto) {
		setDataSaida(data);
		setQuantidade(quantidade);
		setProduto(produto);
	}
	public SaidaProduto() {}
	
	public int getIdSaidaProduto(){
	    return idSaidaProduto;
	}
	
	public Date getDataSaida(){
	    return date;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public Produto getProduto(){
	    return produto;
	}
	
	public Date getDataCriada(){
	    return dataCriada;
	}

	public void setIdSaidaProduto(int idSaidaProduto) {
		this.idSaidaProduto = idSaidaProduto;
	}
	
	public void setDataSaida(Date date) {
		this.date = date;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setDataCriada(Date dataCriada) {
		this.dataCriada = dataCriada;
	}
	
	
	public String toString(){
		return "";
	}
}
