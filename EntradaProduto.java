public class EntradaProduto extends Produto{
	private int idEntradaProduto;

	

	public EntradaProduto(
		int idProduto, String nomeProduto, String descricaoProduto, String setorProduto, String pesoProduto, //super
		int idEntradaProduto,
		String data, String quantidade
		){
		super(idProduto, nomeProduto, descricaoProduto, setorProduto, pesoProduto);
		Movimentacoes movimentacoes = new Movimentacoes();
		movimentacoes.setData(data);
		movimentacoes.setQuantidade(quantidade);	

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
