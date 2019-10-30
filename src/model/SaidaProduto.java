package model;
import java.util.Date;
public class SaidaProduto{
	private int idSaidaProduto;
	private Date date;
	private int quantidade;
	private Produto produto;
	
	public SaidaProduto( Date data, int quantidade, Produto produto) {
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
	public Produto getProduto(){
	    return produto;
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
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	public String toString(){
		return " Id saida do produto: " + Integer.toString(idSaidaProduto) + " ";
	}
}
