import java.util.Date;

public class EntradaProduto extends Movimentacoes{
	private int idEntradaProduto;

	public EntradaProduto(Date data, int quantidade, Produto produto, int idEntradaProduto){
		super(data, quantidade, produto);
		setIdEntradaProduto(idEntradaProduto);
	}
	
	public int getIdEntradaProduto(){
		return idEntradaProduto;
	}	

	public void setIdEntradaProduto(int idEntradaProduto) {
		this.idEntradaProduto = idEntradaProduto;
	}

	public String toString(){
		return super.toString() + " Id Entrada Produto: " + idEntradaProduto;
	}
}
