public class Endereco {
    private  String estado;
    private String cidade;
    private String rua;
    private String bairro;
    private int numero;
    private String cep;

    public Endereco(String estado, String cidade, String rua, String bairro, int numero, String cep){
		setEstado(estado);
		setCidade(cidade);
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
        setCep(cep);
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
	
	public String getNumero(){
	      return numero;
	}
	
	public String getCep(){
	      return cep;
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
}