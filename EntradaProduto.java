import java.util.Date;

public class EntradaProduto extends Movimentacoes{
	private int idEntradaProduto;

	public EntradaProduto( int idEntradaProduto, Date data, int quantidade, Produto produto){
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
		return " Id Entrada Produto: " + idEntradaProduto + super.toString();
	}
}
