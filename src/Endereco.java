public class Endereco {
    private String estado;
    private String cidade;
    private String rua;
    private String bairro;
    private int numero;
    private String cep;
    private Fornecedor fornecedor;
    
    public Endereco(String estado, String cidade, String rua, String bairro, int numero, String cep, Fornecedor fornecedor){
		setEstado(estado);
		setCidade(cidade);
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
        setCep(cep);
        setFuncionario(fornecedor);
	}

    public Endereco() {
    	this.estado = null;
    	this.cidade = null;
    	this.rua = null;
    	this.bairro = null;
    	this.numero = 0;
    	this.cep = null;
    }
    public String getEstado(){
	      return estado;
	}
	
	public String getCidade(){
	      return cidade;
	}
	
	public String getRua(){
	      return rua;
	}

    public String getBairro(){
	      return bairro;
	}
	
	public int getNumero(){
	      return numero;
	}
	
	public String getCep(){
	      return cep;
	}
	
	public Fornecedor getFornecedor(){
	      return fornecedor;
	}

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
			this.cidade = cidade;
	}

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public void setFuncionario(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public String toString(){
		return "com o Estado: " + getEstado() + " com a cidade: " + getCidade() + " com a rua: "+ getRua() + " com o bairro: " + getBairro() + " com o número: " + getNumero() + " com o CEP: " + getCep();
	}
}