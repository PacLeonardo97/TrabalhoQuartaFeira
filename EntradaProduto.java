public class EntradaProduto extends Produto{
	private int idEntradaProduto;
	private String dataEntrada;

	Movimentacoes movimentacoes = new Movimentacoes(data, produto, quantidade);

	public EntradaProduto(
		int idProduto, String nomeProduto, String descricaoProduto, String setorProduto, String pesoProduto,
		int idEntradaProduto, String dataEntrada){
		super(idProduto, nomeProduto, descricaoProduto, setorProduto, pesoProduto);
		movimentacoes.setData(data);
		movimentacoes.setProduto(produto);
		movimentacoes.setQuantidade(quantidade);	
		

		setIdEntradaProduto(idEntradaProduto);
		setDataEntrada(dataEntrada);
	}
	
	//Metodos de acesso - get
		public int getIdEntradaProduto(){
		      return idEntradaProduto;
		}
		
		public String getDataEntrada(){
		      return dataEntrada;
		}
		
		
		//metodos modificadores
			public void setIdEntradaProduto(int idEntradaProduto) {
				this.idEntradaProduto = idEntradaProduto;
			}
			public void setDataEntrada(String dataEntrada) {
				this.dataEntrada = dataEntrada;
			}
	}
