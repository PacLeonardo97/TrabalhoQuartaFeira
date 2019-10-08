import java.util.Date;
public class SaidaProduto extends Movimentacoes{
	private int idSaidaProduto;
	 
	public SaidaProduto(int idSaidaProduto, Date data, int quantidade, Produto produto) {
		super(data, quantidade, produto);
		
		setIdSaidaProduto(idSaidaProduto);
	}
	
	public int getIdSaidaProduto(){
	    return idSaidaProduto;
	}

	public void setIdSaidaProduto(int idSaidaProduto) {
		this.idSaidaProduto = idSaidaProduto;
	}

	public String toString(){
		return " Id saida do produto: " + Integer.toString(idSaidaProduto) + " " + super.toString();
	}
}
