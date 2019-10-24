public class Fornecedor {
	private int idFornecedor; 
	private String nome;
	private String telefone;
	private Endereco endereco;
	private String cnpj;
	
	public Fornecedor(int idFornecedor, String nome, String telefone, Endereco endereco, String cnpj){
		setIdFornecedor(idFornecedor);
		setNome(nome);
		setTelefone(telefone);
		setEndereco(endereco); //fazer objeto endereco
		setCNPJ(cnpj);
	}

	//Metodos de acesso - get
	public int getIdFornecedor(){
	      return idFornecedor;
	}
	
	public String getNome(){
	      return nome;
	}
	
	public String getTelefone(){
	      return telefone;
	}
	
	public Endereco getEndereco(){
	      return endereco;
	}
	
	public String getCNPJ(){
	      return cnpj;
	}
	
	//metodos modificadores
		public void setNome(String nome) {
			this.nome = nome;
		}
		public void setIdFornecedor(int idFornecedor) {
			this.idFornecedor = idFornecedor;
		}


		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public void setCNPJ(String cnpj) {
			this.cnpj = cnpj;
		}

		public String toString(){
			return "id: " + Integer.toString(idFornecedor) + " nome: " + nome + " Telefone:" + telefone + " Endereço: " + endereco + " CNPJ: " + cnpj;
		}
}


