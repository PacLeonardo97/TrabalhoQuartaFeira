import java.util.Date;

public class SaidaProduto extends Movimentacoes{
	 private int idSaidaProduto;
	 
	 public SaidaProduto(Date data, int quantidade, Produto produto,
				int idSaidaProduto) {
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
		return super.toString() + " Id saida do produto: " + idSaidaProduto;
	}
}
