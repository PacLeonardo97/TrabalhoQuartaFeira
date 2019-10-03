public class SaidaProduto extends Estoque {
	private int idSaidaProduto;
	private String dataSaidaProduto;
	
	Movimentacoes movimentacoes = new Movimentacoes(data, produto, quantidade);

	public SaidaProduto (
		int idEstoque, String quantidadeEstoque, //super
		int idSaidaProduto, String dataSaidaProduto) {
		super(idEstoque, quantidadeEstoque);

		movimentacoes.setData(data);
		movimentacoes.setProduto(produto);
		movimentacoes.setQuantidade(quantidade);	

		setIdProduto(idSaidaProduto);
		setNomeProduto(dataSaidaProduto);
	}
	
	public int getIdSaidaProduto(){
	      return idSaidaProduto;
	}
	
	public String getDataSaidaProduto(){
	      return dataSaidaProduto;
	}
	

	public void setIdSaidaProduto(int idSaidaProduto) {
		this.idSaidaProduto = idSaidaProduto;
	}
	
	public void setDataSaidaProduto(String dataSaidaProduto) {
		this.dataSaidaProduto = dataSaidaProduto;
	}
}
