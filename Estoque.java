import java.util.Date;

public class Estoque extends EntradaProduto{
    private int idEstoque;

    public Estoque( int idEstoque, int idEntradaProduto, Date data, int quantidade, Produto produto){
      super(idEntradaProduto, data, quantidade, produto);
      setIdEstoque(idEstoque);
    }

    public int getIdEstoque(){
      return this.idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
	  	this.idEstoque= idEstoque;
    }
}