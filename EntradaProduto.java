public class EntradaProduto extends Produto{
	private int idEntradaProduto;

	private Movimentacoes movimentacoes = new Movimentacoes(data, quantidade);

	public EntradaProduto(
		int idProduto, String nomeProduto, String descricaoProduto, String setorProduto, String pesoProduto, //super
		int idEntradaProduto,
		String dataEntrada, String quantidadeEntrada
		){
		super(idProduto, nomeProduto, descricaoProduto, setorProduto, pesoProduto);
		
		movimentacoes.setData(dataEntrada);
		movimentacoes.setQuantidade(quantidadeEntrada);	

		setIdEntradaProduto(idEntradaProduto);
		
	}
	
	//Metodos de acesso - get
	public int getIdEntradaProduto(){
		return idEntradaProduto;
	}	

	//metodos modificadores
	public void setIdEntradaProduto(int idEntradaProduto) {
		this.idEntradaProduto = idEntradaProduto;
	}

	public String toString(){
		return super.toString() + "id da entrada: " + Integer.toString(idEntradaProduto) + "data da entrada: " + movimentacoes.getData(data) + "quantidade: " + movimentacoes.getQuantidade(quantidade);
	}
}
