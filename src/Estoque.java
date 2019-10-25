public class Estoque {
    private int idEstoque;
//    private EntradaProduto EntradaProduto;
    private int QtdaMin;
    private int QtdaMax;
    //arrayList de entrada produto

    public Estoque( int idEstoque, int QtdaMin, int QtdaMax){
      setIdEstoque(idEstoque);
      setQtdaMin(QtdaMin);
      setQtdaMax(QtdaMax);
    }

    public int getIdEstoque(){
      return this.idEstoque;
    }
    
    public int getQtdaMin() {
    	return this.QtdaMin;
    }
    
    public int getQtdaMax() {
    	return this.QtdaMax;
    }

    public void setIdEstoque(int idEstoque) {
	  	this.idEstoque = idEstoque;
    }
    
    public void setQtdaMin(int QtdaMin) {
	  	this.QtdaMin = QtdaMin;
    }
    
    public void setQtdaMax(int QtdaMax) {
	  	this.QtdaMax = QtdaMax;
    }
}