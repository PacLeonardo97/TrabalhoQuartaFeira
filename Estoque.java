public class Estoque extends EntradaProduto{
    private int idEstoque;
    private int quantidadeEstoque;

    public Estoque(int idEntradaProduto, String dataEntrada, int idEstoque, int quantidadeEstoque){
        super(idEntradaProduto, dataEntrada);
        setIdEstoque(idEstoque);
        setQuantidadeEstoque(quantidadeEstoque);
    }

    public String getIdEstoque(){
        return this.idEstoque;
    }

    public String getQuantidadeEstoque(){
        return this.quantidadeEstoque;
    }

    public void setIdEstoque(int idEstoque) {
		this.idEstoque= idEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
    }
}