import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testando{
    
    public static void main(String[] args) {
    	Produto produto = new Produto(1, "olaMundoCarai", "DescriçãoDoCaramba", 1);

    	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
    	Date data;
    	
		try {
			data = formato.parse("18/04/1997");
	        SaidaProduto saidaProduto = new SaidaProduto( data , 18, produto, 1);
	        
	        System.out.println(saidaProduto.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
}