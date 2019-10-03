public class Movimentacoes {
    private String data;

    private String quantidade;

    public Movimentacoes( String data, String quantidade){
        setData(data);
        setQuantidade(quantidade);
    }

    public String getData(){
        return this.data;
    }

    public String getQuantidade(){
        return this.quantidade;
    }


    public void setData(String data) {
		this.data = data;
    }

    public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
    }

}