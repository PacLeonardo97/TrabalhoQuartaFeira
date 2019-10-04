import java.util.Date;

public class Movimentacoes {
    private Date data;
    private Produto produto;  //objeto produto
    private int quantidade;

    public Movimentacoes( Date data, int quantidade, Produto produto){   	
    	setProduto(produto);
        setData(data);
        setQuantidade(quantidade);
    }
    
    public Date getData(){
        return this.data;
    }

    public int getQuantidade(){
        return this.quantidade;
    }
    
    public Produto produto(){
        return this.produto;
    }
    
    //setando objeto produto
    public void setProduto(Produto produto) {
    	this.produto = produto;
    }
    
    public void setData(Date data) {
		this.data = data;
    }

    public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
    }
    public String toString() {
    	return "Data: " + data + " Quantidade: " + quantidade + " " + produto;
    }
}