public class Estoque{
    private int idEstoque;
    private int quantidadeEstoque;

    public Estoque( int idEstoque, int quantidadeEstoque){
     setIdEstoque(idEstoque);
     setQuantidadeEstoque(quantidadeEstoque);
    }

    public int getIdEstoque(){
      return this.idEstoque;
    }

    public int getQuantidadeEstoque(){
      return this.quantidadeEstoque;
    }

    public void setIdEstoque(int idEstoque) {
	  	this.idEstoque= idEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
	  	this.quantidadeEstoque = quantidadeEstoque;
    }
}