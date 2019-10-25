import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testando{
    
    public static void main(String[] args) {
		//este é o saída produto
    	Produto produto = new Produto(1, "olaMundoCarai", "DescriçãoDoCaramba", 1); //id, nome do produto, Descrição do produto, Peso

    	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    	Date data;
    	
		try {
			data = formato.parse("18/04/1997");
			SaidaProduto saidaProduto = new SaidaProduto(1, data , 18, produto); // Data, quantidade, objeto produto, id
	        
	        System.out.println(saidaProduto.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
}