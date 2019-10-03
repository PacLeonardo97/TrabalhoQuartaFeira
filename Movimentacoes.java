public class Movimentacoes {
    private String data;
    private String produto;
    private String quantidade;

    public Movimentacoes( String data, String produto, String quantidade){
        setData(data);
        setProduto(produto);
        setQuantidade(quantidade);
    }

    public String getData(){
        return this.data;
    }

    public String getProduto(){
        return this.produto;
    }

    public String getQuantidade(){
        return this.quantidade;
    }


    public void setData(String data) {
		this.data = data;
    }

    public void setProduto(String produto) {
		this.produto = produto;
    }

    public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
    }

}