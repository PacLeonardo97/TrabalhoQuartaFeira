package model;
import java.util.Date;

public class EntradaProduto{
	private int idEntradaProduto;
	private Date date;
	private int quantidade;
	private Produto produto;
	
	public EntradaProduto(Date data, int quantidade, Produto produto){
		setDate(data);
		setQuantidade(quantidade);
		setProduto(produto);
	}
	
	public int getIdEntradaProduto(){
	    return idEntradaProduto;
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

	public void setIdEntradaProduto(int idEntradaProduto) {
		this.idEntradaProduto = idEntradaProduto;
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
		return " Id Entrada Produto: " + idEntradaProduto;
	}
}
